package com.app.pojos;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name = "subscriber_tbl")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Subscriber extends BaseEntity
{
  @NotEmpty(message = "name cannot be blank")
  @Length(min = 4,max = 40,message = "invalid name length!!!")
  @Column(length = 30)
  private String subscrName;
  
  @NotNull(message = "phone no cannot be blank")
  @Column(length = 30)
  private String subscrPhoneno;
//  private boolean status; //generated by us
//  private LocalDate subscrDate;
  @Column(length = 20)
	private String city;
	@Column(length = 20)
	private String state;
	@Column(length = 20)
	private String country;
	@Column(length = 20,name="zip_code")
	private String zipCode;
	@Column(length = 500,name="address")
	@NotEmpty(message = "location must be supplied")
  private String location;
	//@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)//if we not make lazy it also fires select quey on rule table also
  @JoinColumn(name = "rule_id",nullable = false) ///representing fk column and nullable = false->fk cannot null
  private Rule rule; 
  @Column(length = 20)
  private String status;
  private LocalDate subscrDate;
  @OneToOne
  @JoinColumn(name="s_id",nullable = false) 
  private UserEntity user;
  
}
