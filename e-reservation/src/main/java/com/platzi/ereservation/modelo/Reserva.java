/**
 * 
 */
package com.platzi.ereservation.modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

/**
 * @author Juan Pablo
 *
 */
@Data
@Entity
@Table(name="reserva")
public class Reserva {
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy="uuid2")
	private String idRes;
	//Para que solo tome la fecha, tambien se puede solo la hora y fecha y hora
	@Temporal(TemporalType.DATE)
	private Date fechaIngresoRes;
	@Temporal(TemporalType.DATE)
	private Date fechaSalidaRes;
	private int cantidadPersonasRes;
	private String descripcionRes;
	@ManyToOne
	@JoinColumn(name="idCli")
	private Cliente cliente;

}
