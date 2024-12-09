
import classes.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lpoo.sistemaautoescola.dao.PersistenciaJPA;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author adrie
 */
public class TestePersistencia {
    PersistenciaJPA jpa = new PersistenciaJPA();
    public TestePersistencia() {
    }
    
    @Before
    public void setUp() {
        if(jpa.conexaoAberta()){
            System.out.println("Conexão aberta.");
        }
        else{
            System.out.println("Erro ao abrir conexão.");
        }
    }
    
    @After
    public void tearDown() {
        jpa.fecharConexao();
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void teste(){
        
        try {
        Administrativo adm = new Administrativo();
        Aluno al = new Aluno();
        Curso c = new Curso(); //quase
        Instrutor i = new Instrutor();
        List<Aula> a = new ArrayList<>();
        
        Calendar calendar = Calendar.getInstance();
        calendar.set(1999, Calendar.JANUARY, 1);
        Date data = calendar.getTime();
        
        Aula aula1 = new Aula();
        aula1.setConcluida(true);
        aula1.setDia_aula(data);
        
        calendar.set(1999, Calendar.JANUARY, 1);
        data = calendar.getTime();
        
        adm.setNome("Carla");
        adm.setCpf("12345678910");
        adm.setData_de_nasc(data);
        adm.setTelefone("54912345678");
        adm.setCargo(Cargo.RECEPCIONISTA);
//        adm.addCurso(c);

        jpa.persist(adm);
        
        
        
        calendar.set(1995, Calendar.JULY, 30);
        data = calendar.getTime();
        
        i.setNome("Severino");
        i.setCpf("12345678912");
        i.setData_de_nasc(data);
        i.setTelefone("55913249876");
        i.setCnh("2222");
//        i.addCurso(c);


        jpa.persist(i);
        
        calendar.set(2006, Calendar.MAY, 6);
        data = calendar.getTime();
        
        al.setNome("Felipe");
        al.setCpf("12345678911");
        al.setData_de_nasc(data);
        al.setRenach("1111");
        al.setMatricula("1234");
        al.setTelefone("56978945632");
//        al.addCurso(c);

        jpa.persist(al);
        
//        System.out.println(al.getCurso());
        
        calendar.set(2024, Calendar.MAY, 12);
        data = calendar.getTime();
        c.setCarga_horaria(60);
        c.setCategoria(Categoria.A);
        c.setData_inicio(data);
        Aluno alx = (Aluno)jpa.find(Aluno.class, (Integer)al.getId());
        Administrativo admx = (Administrativo)jpa.find(Administrativo.class, (Integer)adm.getId());
        Instrutor ix = (Instrutor)jpa.find(Instrutor.class, (Integer)i.getId());
        c.setAluno(alx);
        c.setAdministrativo(admx);
        c.setInstrutor(ix);
        c.setAulas(a);
        c.addAula(aula1);
        c.addAula(aula1);
        c.addAula(aula1);
        c.setFinalizado(false);
        
        
//        al.setCurso(c);
//        ha.setCurso(c);
        
            jpa.persist(c);
        } catch (Exception ex) {
            Logger.getLogger(TestePersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
