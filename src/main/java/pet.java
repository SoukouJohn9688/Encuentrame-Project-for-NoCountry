import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class pet {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private enum especie{
        perro,
        gato

    };

    private String raza;
    private  Integer edad_meses;
    private String color;
    private enum tamaño{
        chico,
        mediano,
        grande
    }

    private String descripcion;
    private Integer id_cuidador;



}
