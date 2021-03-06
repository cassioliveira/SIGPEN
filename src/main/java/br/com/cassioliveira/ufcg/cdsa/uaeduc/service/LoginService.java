package br.com.cassioliveira.ufcg.cdsa.uaeduc.service;

import br.com.cassioliveira.ufcg.cdsa.uaeduc.exception.NegocioException;
import br.com.cassioliveira.ufcg.cdsa.uaeduc.model.Login;
import br.com.cassioliveira.ufcg.cdsa.uaeduc.repository.Logins;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;

/**
 *
 * @author cassio
 */
public class LoginService implements Serializable {

    @Inject
    private Logins logins;

    @Transactional
    public void save(Login product) throws NegocioException {
        this.logins.salvar(product);
    }

    @Transactional
    public void delete(Login product) throws NegocioException {
        logins.excluir(findById(product.getId()));
    }

    public Login findById(Long id) {
        return logins.porId(id);
    }

    public List<Login> findAll() {
        return logins.todos();
    }

}
