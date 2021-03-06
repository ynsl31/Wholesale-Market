package ma.sic.mg.ballance.entities;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIgnoreProperties(value = ("pesage"), allowSetters = true)

public class Recu implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	
	@OneToOne
	private Pesage pesage;

	@OneToOne(mappedBy = "recu", cascade = CascadeType.ALL)
	private Reglement reglement;

}
