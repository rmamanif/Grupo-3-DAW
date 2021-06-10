package aplicaciones.spring.modelo;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.sun.istack.NotNull;
@Entity
@Table(name="CLIENTES")
public class Cliente {
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long id;
		@NotNull
		private String nombres;
		@NotNull
		private String apellidos;
		@NotNull
		private Integer dni;
		@NotNull
		private Integer telefono;
		@NotNull
		private String direccion;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getNombres() {
			return nombres;
		}
		public void setNombres(String nombres) {
			this.nombres = nombres;
		}
		public String getApellidos() {
			return apellidos;
		}
		public void setApellidos(String apellidos) {
			this.apellidos = apellidos;
		}
		public Integer getDni() {
			return dni;
		}
		public void setDni(Integer dni) {
			this.dni = dni;
		}
		public Integer getTelefono() {
			return telefono;
		}
		public void setTelefono(Integer telefono) {
			this.telefono = telefono;
		}
		public String getDireccion() {
			return direccion;
		}
		public void setDireccion(String direccion) {
			this.direccion = direccion;
		}
		
		public Cliente() {
			super();
		}
		
		public Cliente(Long id, String nombres, String apellidos, Integer dni, Integer telefono, String direccion) {
			super();
			this.id = id;
			this.nombres = nombres;
			this.apellidos = apellidos;
			this.dni = dni;
			this.telefono = telefono;
			this.direccion = direccion;
		}
		
		@Override
		public String toString() {
			return "Cliente [id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + ", dni=" + dni
					+ ", telefono=" + telefono + ", direccion=" + direccion + "]";
		}
		
}
