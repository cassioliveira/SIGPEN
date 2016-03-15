package br.com.cassioliveira.ufcg.cdsa.uaeduc.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
@Entity
@Data
public class Professor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Um nome deve ser informado")
    @Column(name = "nome", nullable = false, length = 200)
    private String nome;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_controle")
    private Date data;
    
//    @ManyToMany(targetEntity = Pendencia.class, mappedBy = "professores")
//    private List<Pendencia> pendencia = new ArrayList<>();

//    @ManyToOne(cascade = CascadeType.ALL, optional = false)
//    @JoinColumn(name = "professor_pendencia", referencedColumnName = "id")
//    private Pendencia pendencia;

}
