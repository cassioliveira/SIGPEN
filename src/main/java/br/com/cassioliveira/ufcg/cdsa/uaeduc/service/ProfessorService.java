package br.com.cassioliveira.ufcg.cdsa.uaeduc.service;

import br.com.cassioliveira.ufcg.cdsa.uaeduc.controller.DateTimeUtilBean;
import br.com.cassioliveira.ufcg.cdsa.uaeduc.exception.NegocioException;
import br.com.cassioliveira.ufcg.cdsa.uaeduc.model.Professor;
import br.com.cassioliveira.ufcg.cdsa.uaeduc.repository.Professores;
import br.com.cassioliveira.ufcg.cdsa.uaeduc.util.jpa.Transactional;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
public class ProfessorService implements Serializable {

    public static final long serialVersionUID = 1L;

    @Inject
    private Professores professores;

    /**
     * Método utilizado para salvar um novo cadastro no banco de dados ou editar
     * um cadastro existente.
     *
     * @param professor
     */
    @Transactional
    public void salvar(Professor professor) {
        professor.setData(new DateTimeUtilBean().getDateToday());
        this.professores.salvar(professor);
    }

    /**
     * Método utilizado para remover um cadastro do banco de dados.
     *
     * @param professor
     * @throws NegocioException
     */
    @Transactional
    public void delete(Professor professor) throws NegocioException {
        professores.delete(findById(professor.getId()));
    }

    /**
     * Método utilizado para buscar um registro no banco de dados para
     * determinada entidade através da passagem do seu ID como parâmetro.
     *
     * @param id
     * @return
     */
    public Professor findById(Long id) {
        return professores.findById(id);
    }

    /**
     * Método responsável pela busca em toda lista.Método utilizado para
     * retornar uma lista com todos os resultados encontrados no banco de dados
     * para a entidade que a chamar.
     *
     * @return
     */
    public List<Professor> findAll() {
        return professores.findAll();
    }

    /**
     * Recebe o valor passado pelo método buscarPorCampo() para determinar a
     * duplicidade do cadastro e lança uma exceção informando ao usuário qual
     * campo não pode ser inserido por já existir no banco de dados.
     *
     * @param campo
     * @param valor
     * @param id
     * @param professor
     */
    public void checaCampoDuplicado(String campo, Object valor, Long id, Professor professor) {
        professores.checaCampoDuplicado(campo, valor, null, professor);
    }

}
