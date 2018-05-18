package br.edu.eteczl.thiagoafonso.ProjetoHibernate;

import java.util.ArrayList;

import javax.swing.JFrame;

import org.hibernate.Session;

import br.edu.eteczl.thiagoafonso.ProjetoHibernate.model.Cliente;
import br.edu.eteczl.thiagoafonso.ProjetoHibernate.persistence.ClienteHibernateDAO;
import br.edu.eteczl.thiagoafonso.ProjetoHibernate.persistence.HibernateUtil;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;

/**
 * Hello world!
 *
 */
public class App extends JFrame
{
    public static void main( String[] args )
    {
        inserirCadastros();
    }
    
  public static void inserirCadastros() {
	  
	  Cliente cl = new Cliente();
	  
	  ArrayList<Cliente> clList = new ArrayList();
      
	  //Cliente 1
	  
      cl.setNome("Huguinho");
      cl.setEmail("Hugui@Uol");
      cl.setEndereco("end do Huguinho");
      cl.setFone("1234");
      clList.add(cl);
      
      //Cliente 2
      
      Cliente cl2 = new Cliente();
      cl2.setNome("Roberto Carlos");
      cl2.setEmail("RobertC@Yahoo");
      cl2.setEndereco("Av. Copacabana");
      cl2.setFone("33334444");
      clList.add(cl2);
      
      //Cliente 3
      
      Cliente cl3 = new Cliente();
      cl3.setNome("Aline Barbosa");
      cl3.setEmail("ABarbosa@gmail");
      cl3.setEndereco("Rua: Baumer, Nº123");
      cl3.setFone("1155554444");
      clList.add(cl3);
      
      //Cliente 4            
      
      Cliente cl4 = new Cliente();
      cl4.setNome("Mathues Santiago");
      cl4.setEmail("MathSantiago@hotmail");
      cl4.setEndereco("Rua: Imaginary Street");
      cl4.setFone("1133334444");
      clList.add(cl4);
      
      //cliente  5
      
      Cliente cl5 = new Cliente();
      cl5.setNome("Maria Isabel");
      cl5.setEmail("BebelMaria@Yahoo");
      cl5.setEndereco("Rua: Cardoso");
      cl5.setFone("1144445566");
      clList.add(cl5);
      
      //cliente 6 
      Cliente cl6 = new Cliente();
      cl6.setNome("Carlos rogerio");
      cl6.setEmail("CarlosRoger@hotmail");
      cl6.setEndereco("Rua: Gertulio");
      cl6.setFone("1122223344");
      clList.add(cl6);
      
      Session session = HibernateUtil.getSessionFactory().openSession();            
      ClienteHibernateDAO<Cliente> clienteDao = new ClienteHibernateDAO<Cliente>(session);
      
      for(int i = 0; i < clList.size(); i++) {

      clienteDao.beginTransaction();
      clienteDao.persistir(clList.get(i));
      clienteDao.commit();
      
      }
      
      clienteDao.closeSession();
  }
}
