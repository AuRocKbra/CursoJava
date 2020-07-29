package com.aurock.CursoJava.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.aurock.CursoJava.entities.enuns.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="tb_order")
/* Foi necessário definir um nome para a tabela desta entidade pois a palavra "order" é uma palavra reservada
 * o SQL, ocorrento conflito na hora da construção. Padrão adotado para todas as entidade tb_nome da tabela
 * */
public class Order implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'",timezone = "GMT")
	/*
	 * Permite definir como será o formato apresentado no json
	 * */
	private Instant moment;
	
	
	@ManyToOne //Permite mapear o relacionamento entre as entidade, no caso muitos Order por client
	@JoinColumn(name="clientId") //Permite definir o nome da coluna referente a chave estrangeira
	private User client;
	
	private Integer orderStatus;
	
	@OneToMany(mappedBy = "id.order")
	private Set<OrderItem> items = new HashSet<>();
	
	/*
	 * Como a classe pagamento depende da classe pedido para existir, o atributo que faz referencia a classe pagamento recebe a 
	 * notação OneToOne(mappedBy="x", cascade = CascadeType.All) onde x será o nome do atributo na classe pagamento que faz 
	 * referencia a esta classe e o CascadeType.All permite determinar que o valor entre pedido e pagamento seja o mesmo.
	 * */
	@OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
	private Payment payment;
	
	public Order() {}

	public Order(Long id, Instant moment, User client,OrderStatus orderStatus) {
		this.id = id;
		this.moment = moment;
		this.client = client;
		setOrderStatus(orderStatus);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}

	public OrderStatus getOrderStatus() {
		return OrderStatus.valueOf(orderStatus);
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		if(orderStatus != null) {
			this.orderStatus = orderStatus.getCode();
		}
	}
	
	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Set<OrderItem> getItems(){
		return items;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
