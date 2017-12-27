/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bisu.contracts;

/**
 *
 * @author ivankrister
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
/**
 *
 * @author ivankrister
 */
abstract public class AbstractModel {
    private SessionFactory session = HibernateUtil.getSessionFactory();
    private Transaction transaction;
    private ArrayList<String> whereCondtion = new ArrayList<String>();
    private ArrayList<String> orWhereCondtion = new ArrayList<String>();
    private Class model;

    public AbstractModel(Class model) {
        this.model = model;
    }
    
    
    protected Session session(){
        return session.getCurrentSession();
    }
    protected void begin(){
        transaction = session.getCurrentSession().beginTransaction();
    }
    protected void end(){
        transaction.commit();
        session.getCurrentSession().close();
    }
    
    
    
    
    public List all() {
        List all;
        
        begin();
        
        all = session().createQuery("from "+this.model.getSimpleName()).list();
        
        end();
        
        return all;
    }
     
   
   public boolean delete(Object model) {
        
        begin();
        
        session().delete(model);
        
        end();
        return true;
   }
    public Object find(Integer id) {
        Object department;
        begin();
        
        department = (Object)session().get(this.model, id);
       
        end();
        
        return department;
    }
    
     public Object save(Object department) {
        begin();
        
        session().saveOrUpdate((Object) department);
        
        end();
        return department;
   }
    
    
    
    
    
    
    
    
    
    public void where(String column, String value){
       
        this.whereCondtion.add(this.getClause(column, value));
    }
    public void where (String column, String operation, String value){
       
        this.whereCondtion.add(this.getClause(column, operation, value));
    }
    public void orWhere(String column, String value){
      
        this.orWhereCondtion.add(this.getClause(column, value));
        
    }
    public void orWhere (String column, String operation, String value){
 
        this.orWhereCondtion.add(this.getClause(column, operation, value));
    }
    
    public void get(){
        
        System.out.println(this.statement());
    }
    
    public String statement(){
        String statement = "SELECT FROM actors";
        
        if(!this.whereCondtion.isEmpty() || !this.orWhereCondtion.isEmpty()){
            statement = statement+ " WHERE ";
            statement = statement + String.join(" AND ", this.whereCondtion);
            if(!this.whereCondtion.isEmpty() && !this.orWhereCondtion.isEmpty())
            {
                statement = statement + " OR ";
            }
            statement = statement + String.join(" OR ", this.orWhereCondtion);

        }
        
        return statement.trim();
    
    }
    
    public Class getModel(){
        return this.model;
    }
    
    
    
    private String getClause(String column, String value){
        
        return column+" = "+value;
    }
    private String getClause(String column, String operation, String value){
        String[] operators = new String[]{"=", "!=", ">=", "<=",">","<"};
        
        boolean result = Arrays.stream(operators).anyMatch(operation::equals);
        if (!result) {
           operation = "=";
        }
       
        return column+" "+operation+" "+value;
    }
}
