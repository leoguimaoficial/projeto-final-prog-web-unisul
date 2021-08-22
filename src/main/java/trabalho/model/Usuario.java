package trabalho.model;
import javax.persistence.GenerationType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")

public class Usuario {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "login", nullable = false)
	private String login;

	@Column(name = "senha", nullable = false)
	private String senha;

	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "cpf", nullable = false)
	private String cpf;

	@Column(name = "data_nasc", nullable = false)
	private String datanasc;

	@Column(name = "sexo", nullable = false)
	private String sexo;

	@Column(name = "estado", nullable = false)
	private String estado;
	public Usuario() {
		
	}
	public Usuario(Long id, String login, String senha, String nome, String cpf, String datanasc, String sexo, String estado) {
		this.id = id;
		this.login = login;
this.senha=senha;
this.nome=nome;
this.cpf=cpf;
this.datanasc=datanasc;
this.sexo=sexo;
this.estado=estado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDatanasc() {
		return datanasc;
	}

	public void setDatanasc(String datanasc) {
		this.datanasc = datanasc;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario)) return false;

        Usuario usuario = (Usuario) o;

        return getId() == usuario.getId();
    }

    @Override
    public int hashCode() {
        return (int) (getId() ^ (getId() >>> 32));
    }

    public void copiarAtributos(Usuario objeto){
        Field[] fieldsObjetoAntigo = this.getClass().getDeclaredFields();
        Field[] fieldsObjetoNovo = objeto.getClass().getDeclaredFields();

        for (Field currentFieldsAntigo : fieldsObjetoAntigo){
            for (Field currentFieldsNovo: fieldsObjetoNovo){
                String nomeFieldAntigo = currentFieldsAntigo.getName();
                String nomeFielNovo = currentFieldsNovo.getName();
                if(nomeFieldAntigo.equals(nomeFielNovo)){
                    currentFieldsAntigo.setAccessible(true);
                    currentFieldsNovo.setAccessible(true);
                    try {
                        currentFieldsAntigo.set(this, currentFieldsNovo.get(objeto));
                    }catch (IllegalAccessException e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}

