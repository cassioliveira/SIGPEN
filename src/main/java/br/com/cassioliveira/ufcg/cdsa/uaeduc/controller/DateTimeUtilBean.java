package br.com.cassioliveira.ufcg.cdsa.uaeduc.controller;

import java.io.Serializable;
import java.util.Date;
import javax.enterprise.inject.Model;

/**
 * Classe utilitária que provê métodos relacionados a datas. Anotada como um
 * Bean CDI, pode ser usada diretamente nas paginas tambem.
 *
 * @author cassio <cassio@cassioliveira.com.br>
 */
@Model
public class DateTimeUtilBean implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Construtor da classe
     */
    public DateTimeUtilBean() {
    }

    /**
     * Retorna a data de hoje incluindo a hora atual.
     *
     * @return
     */
    public Date getDateToday() {
        return new Date();
    }
}
