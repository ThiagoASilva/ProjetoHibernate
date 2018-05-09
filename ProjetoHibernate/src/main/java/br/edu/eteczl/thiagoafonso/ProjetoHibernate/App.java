package br.edu.eteczl.thiagoafonso.ProjetoHibernate;

import javax.swing.JFrame;

import org.hibernate.Session;

import br.edu.eteczl.thiagoafonso.ProjetoHibernate.model.Cliente;
import br.edu.eteczl.thiagoafonso.ProjetoHibernate.persistence.ClienteHibernateDAO;
import br.edu.eteczl.thiagoafonso.ProjetoHibernate.persistence.HibernateUtil;

/**
 * Hello world!
 *
 */
public class App extends JFrame
{
    public static void main( String[] args )
    {
        Cliente cl = new Cliente();
        
        cl.setNome("Huguinho");
        cl.setEndereco("end do Huguinho");
        cl.setFone("1234");
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        ClienteHibernateDAO<Cliente> clienteDao = new ClienteHibernateDAO<Cliente>(session);
        clienteDao.beginTransaction();
        clienteDao.persistir(cl);
        clienteDao.commit();
        clienteDao.closeSession();
    }
}
