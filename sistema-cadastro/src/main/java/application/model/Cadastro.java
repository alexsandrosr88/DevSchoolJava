package application.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import application.model.enums.Sexo;



@Entity
public class Cadastro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 50, nullable = false)
	private String nome;
	@Column(length = 70, nullable = false)
	private String email;
	@Column(length = 20, nullable = false)
	private String rg;
	@Column(length = 15, nullable = false, unique = true)
	private String cpf;
	@Column(length = 15, nullable = false)
	private Long celular;
	
	@OneToOne
	@JoinColumn(name ="fk_cadastro_endereco", foreignKey = @ForeignKey(name="fk_cadastro_endereco"))
	private Endereco endereco;
	
	@Column(length = 15, nullable = false)
	private String nacionalidade;
	
	@Column(nullable = false, name = "dt_nascimento")
	private LocalDate dataNascimento;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataHoraCadastro;
	
	@Embedded
	private ContatoEmergencia contato;
	
	@Embedded
	@AttributeOverrides( {
        @AttributeOverride(name="nome", column = @Column(name="ce2_nome") ),
        @AttributeOverride(name="email", column = @Column(name="ce2_email") ),
        @AttributeOverride(name="parentesco", column = @Column(name="ce2_parentesco") ),
        @AttributeOverride(name="telefone", column = @Column(name="ce2_telefone") )
	} )
	private ContatoEmergencia contato2;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 1, nullable = false)
	private Sexo sexo;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
