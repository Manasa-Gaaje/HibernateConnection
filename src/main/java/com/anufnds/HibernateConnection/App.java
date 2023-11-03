package com.anufnds.HibernateConnection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.anufnds.Models.Passport;
import com.anufnds.Models.Person;
import com.anufnds.Models.Student;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	 Configuration cfg=new Configuration();
         cfg.configure("hibernate.cfg.xml");
         SessionFactory factory=cfg.buildSessionFactory();
         Session session=factory.openSession();
         try
         {
        	 /*
        	 Student s1= new Student();
        	 s1.setName("Swathi");
        	 s1.setMarks(90);
        	 session.beginTransaction();
        	 session.save(s1);
        	 session.getTransaction().commit();
        	 
        	 
        	 Student s2= new Student();
        	 s2.setName("Swetha");
        	 s2.setMarks(85);
        	 session.beginTransaction();
        	 session.save(s2);
        	 session.getTransaction().commit();
        	 */
        	 
        	 Person p1=new Person();
        	 p1.setName("Sneha");
        	 
        	 Passport pn= new Passport();
        	 pn.setPassportnumber("ABJY125718");
        	 
        	 p1.setPassport(pn);
        	 pn.setPerson(p1);
        	 
        	 session.beginTransaction();
        	 session.save(p1);
        	 session.getTransaction().commit();
        	 
        	 Person a1=session.get(Person.class,p1.getId());
        	 Passport a2=a1.getPassport();
        	 
        	 
        	 System.out.println("Person name:"+a1.getName());
        	 System.out.println("Passport number:"+a2.getPassportnumber());
        	 
         }
        catch(Exception e)
         {
        	e.printStackTrace();
        	
         }
         finally
         {
        	 session.close();
        	 factory.close();
         }
         
    }
}
