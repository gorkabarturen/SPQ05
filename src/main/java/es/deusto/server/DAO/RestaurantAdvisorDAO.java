package es.deusto.server.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import es.deusto.server.DTO.MemberDTO;
import es.deusto.server.DTO.RestaurantDTO;
import es.deusto.server.jdo.*;

import es.deusto.server.jdo.*;

public class RestaurantAdvisorDAO {
	// Load Persistence Manager Factory - referencing the Persistence Unit defined in persistence.xml
	PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	// Persistence Manager
	PersistenceManager pm = null;
	//Transaction to group DB operations
	Transaction tx = null;	

	@SuppressWarnings("finally")
	public List<RestaurantDTO> getRestaurantByName(String text) {
		List<RestaurantDTO> r = new ArrayList<RestaurantDTO>();
		try{
			System.out.println("INFO: Getting the Restaurant from the db: ");
			pm = pmf.getPersistenceManager();
			//Obtain the current transaction
			 tx = pm.currentTransaction();		
			//Start the transaction
			tx.begin();

			Extent<Restaurant> extent = pm.getExtent(Restaurant.class, true);

			for (Restaurant restaurant : extent) {
				if(restaurant.getNameR().equals(text))
					r.add(new RestaurantDTO(restaurant.getNameR(),
											restaurant.getRate(),
											restaurant.getNumRates(),
											restaurant.getCategory(),
											restaurant.getStreet(),
											new ArrayList<Comment>(),
											restaurant.getCity()));				
			}
			tx.commit();
			System.out.println("Restaurant retrieves successfully");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("WARN: Exception when retrieving from database");
		}finally{
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
			return r;
		}

	}

	@SuppressWarnings("finally")
	public List<RestaurantDTO> getRestaurantByCategory(String text) {
		List<RestaurantDTO> r = new ArrayList<RestaurantDTO>();
		try{
			System.out.println("INFO: Getting the Restaurant from the db: ");
			pm = pmf.getPersistenceManager();
			//Obtain the current transaction
			tx = pm.currentTransaction();		
			//Start the transaction
			tx.begin();

			Extent<Restaurant> extent = pm.getExtent(Restaurant.class, true);

			for (Restaurant restaurant : extent) {
				if(restaurant.getCategory().equals(text))
					r.add(new RestaurantDTO(restaurant.getNameR(),
							restaurant.getRate(),
							restaurant.getNumRates(),
							restaurant.getCategory(),
							restaurant.getStreet(),
							new ArrayList<Comment>(),
							restaurant.getCity()));				
			}
			System.out.println(r.get(0).toString());
			tx.commit();
			System.out.println("Restaurant retrieves successfully");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("WARN: Exception when retrieving from database");
		}finally{
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
			return r;
		}

	}
	@SuppressWarnings("finally")
	public List<RestaurantDTO> getRestaurantByPlace(String text) {
		List<RestaurantDTO> r = new ArrayList<RestaurantDTO>();
		try{
			System.out.println("INFO: Getting the Restaurant from the db: ");
			pm = pmf.getPersistenceManager();
			//Obtain the current transaction
			tx = pm.currentTransaction();		
			//Start the transaction
			tx.begin();

			Extent<Restaurant> extent = pm.getExtent(Restaurant.class, true);

			for (Restaurant restaurant : extent) {
				if(restaurant.getCity().toString().equals(text))
					r.add(new RestaurantDTO(restaurant.getNameR(),
							restaurant.getRate(),
							restaurant.getNumRates(),
							restaurant.getCategory(),
							restaurant.getStreet(),
							new ArrayList<Comment>(),
							restaurant.getCity()));			
			}

			tx.commit();
			System.out.println("Restaurant retrieves successfully");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("WARN: Exception when retrieving from database");
		}finally{
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
			return r;
		}

	}
	@SuppressWarnings("finally")
	public List<RestaurantDTO> getRestaurantByRate(String text) {
		List<RestaurantDTO> r = new ArrayList<RestaurantDTO>();
		try{
			System.out.println("INFO: Getting the Restaurant from the db: ");
			pm = pmf.getPersistenceManager();
			//Obtain the current transaction
			tx = pm.currentTransaction();		
			//Start the transaction
			tx.begin();

			Extent<Restaurant> extent = pm.getExtent(Restaurant.class, true);

			for (Restaurant restaurant : extent) {
				if(restaurant.getRate().equals(text))
					r.add(new RestaurantDTO(restaurant.getNameR(),
							restaurant.getRate(),
							restaurant.getNumRates(),
							restaurant.getCategory(),
							restaurant.getStreet(),
							new ArrayList<Comment>(),
							restaurant.getCity()));			
			}
			System.out.println(r);

			tx.commit();
			System.out.println("Restaurant retrieves successfully");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("WARN: Exception when retrieving from database");
		}finally{
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
			return r;
		}

	}
	@SuppressWarnings("finally")
	public List<RestaurantDTO> getRestaurantByNameAndCategory(String text, String text1) {
		List<RestaurantDTO> r = new ArrayList<RestaurantDTO>();
		try{
			System.out.println("INFO: Getting the Restaurant from the db: ");
			pm = pmf.getPersistenceManager();
			//Obtain the current transaction
			tx = pm.currentTransaction();		
			//Start the transaction
			tx.begin();

			Extent<Restaurant> extent = pm.getExtent(Restaurant.class, true);

			for (Restaurant restaurant : extent) {
				if(restaurant.getNameR().equals(text) && restaurant.getCategory().equals(text1))
					r.add(new RestaurantDTO(restaurant.getNameR(),
							restaurant.getRate(),
							restaurant.getNumRates(),
							restaurant.getCategory(),
							restaurant.getStreet(),
							new ArrayList<Comment>(),
							restaurant.getCity()));				
			}

			tx.commit();
			System.out.println("Restaurant retrieves successfully");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("WARN: Exception when retrieving from database");
		}finally{
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
			return r;
		}

	}
	@SuppressWarnings("finally")
	public List<RestaurantDTO> getRestaurantByNameAndRate(String text, String text1) {
		List<RestaurantDTO> r = new ArrayList<RestaurantDTO>();
		try{
			System.out.println("INFO: Getting the Restaurant from the db: ");
			pm = pmf.getPersistenceManager();
			//Obtain the current transaction
			tx = pm.currentTransaction();		
			//Start the transaction
			tx.begin();

			Extent<Restaurant> extent = pm.getExtent(Restaurant.class, true);

			for (Restaurant restaurant : extent) {
				if(restaurant.getNameR().equals(text) && restaurant.getRate().equals(text1))
					r.add(new RestaurantDTO(restaurant.getNameR(),
							restaurant.getRate(),
							restaurant.getNumRates(),
							restaurant.getCategory(),
							restaurant.getStreet(),
							new ArrayList<Comment>(),
							restaurant.getCity()));				
			}

			tx.commit();
			System.out.println("Restaurant retrieves successfully");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("WARN: Exception when retrieving from database");
		}finally{
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
			return r;
		}

	}
	@SuppressWarnings("finally")
	public List<RestaurantDTO> getRestaurantByNameAndPlace(String text, String text1) {
		List<RestaurantDTO> r = new ArrayList<RestaurantDTO>();
		try{
			System.out.println("INFO: Getting the Restaurant from the db: ");
			pm = pmf.getPersistenceManager();
			//Obtain the current transaction
			tx = pm.currentTransaction();		
			//Start the transaction
			tx.begin();				

			Extent<Restaurant> extent = pm.getExtent(Restaurant.class, true);

			for (Restaurant restaurant : extent) {
				if(restaurant.getNameR().equals(text) && restaurant.getCity().toString().equals(text1))
					r.add(new RestaurantDTO(restaurant.getNameR(),
							restaurant.getRate(),
							restaurant.getNumRates(),
							restaurant.getCategory(),
							restaurant.getStreet(),
							new ArrayList<Comment>(),
							restaurant.getCity()));					
			}

			tx.commit();
			System.out.println("Restaurant retrieves successfully");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("WARN: Exception when retrieving from database");
		}finally{
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
			return r;
		}


	}
	@SuppressWarnings("finally")
	public List<RestaurantDTO> getRestaurantByPlaceAndCategory(String text, String text1) {
		List<RestaurantDTO> r = new ArrayList<RestaurantDTO>();
		try{
			System.out.println("INFO: Getting the Restaurant from the db: ");
			pm = pmf.getPersistenceManager();
			//Obtain the current transaction
			tx = pm.currentTransaction();		
			//Start the transaction
			tx.begin();				

			Extent<Restaurant> extent = pm.getExtent(Restaurant.class, true);

			for (Restaurant restaurant : extent) {
				if(restaurant.getCity().toString().equals(text) && restaurant.getCategory().equals(text1))
					r.add(new RestaurantDTO(restaurant.getNameR(),
							restaurant.getRate(),
							restaurant.getNumRates(),
							restaurant.getCategory(),
							restaurant.getStreet(),
							new ArrayList<Comment>(),
							restaurant.getCity()));					
			}

			tx.commit();
			System.out.println("Restaurant  retrieves successfully");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("WARN: Exception when retrieving from database");
		}finally{
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
			return r;
		}

	}

	@SuppressWarnings("finally")
	public List<RestaurantDTO> getRestaurantByPlaceAndRate(String text, String text1) {
		List<RestaurantDTO> r = new ArrayList<RestaurantDTO>();
		try{
			System.out.println("INFO: Getting the Restaurant from the db: ");
			pm = pmf.getPersistenceManager();
			//Obtain the current transaction
			tx = pm.currentTransaction();		
			//Start the transaction
			tx.begin();				

			Extent<Restaurant> extent = pm.getExtent(Restaurant.class, true);

			for (Restaurant restaurant : extent) {
				if(restaurant.getCity().toString().equals(text) && restaurant.getRate().equals(text1))
					r.add(new RestaurantDTO(restaurant.getNameR(),
							restaurant.getRate(),
							restaurant.getNumRates(),
							restaurant.getCategory(),
							restaurant.getStreet(),
							new ArrayList<Comment>(),
							restaurant.getCity()));			
			}

			tx.commit();
			System.out.println("Restaurant retrieves successfully");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("WARN: Exception when retrieving from database");
		}finally{
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
			return r;
		}
	}
	@SuppressWarnings("finally")
	public List<RestaurantDTO> getRestaurantByCategoryAndRate(String text, String text1) {
		List<RestaurantDTO> r = new ArrayList<RestaurantDTO>();
		try{
			System.out.println("INFO: Getting the Restaurant from the db: ");
			pm = pmf.getPersistenceManager();
			//Obtain the current transaction
			tx = pm.currentTransaction();		
			//Start the transaction
			tx.begin();				
			Extent<Restaurant> extent = pm.getExtent(Restaurant.class, true);
			for (Restaurant restaurant : extent) {
				if(restaurant.getCategory().equals(text) && restaurant.getRate().equals(text1))
					r.add(new RestaurantDTO(restaurant.getNameR(),
							restaurant.getRate(),
							restaurant.getNumRates(),
							restaurant.getCategory(),
							restaurant.getStreet(),
							new ArrayList<Comment>(),
							restaurant.getCity()));	
			}

			tx.commit();
			System.out.println("Restaurant retrieves successfully");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("WARN: Exception when retrieving from database");
		}finally{
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
			return r;
		}

	}

	public void createDatabase(){
		try {
			System.out.println("- Store objects in the DB");
			City city = new City("Bilbao","49020",new ArrayList<Restaurant>());
			City city2 = new City("Londres","547978943",new ArrayList<Restaurant>());
			City city3 = new City("Valencia","345345",new ArrayList<Restaurant>());
			
			Restaurant restaurant1 = new Restaurant("Telepizza", "0", "0", "Italian", "", new ArrayList<Comment>(),city);
//			Restaurant restaurant2 = new Restaurant("Telepizza", "0", "0", "Italian", "", new ArrayList<Comment>(), city2);
//			Restaurant restaurant3 = new Restaurant("Telepizza", "0", "0", "Italian", "", new ArrayList<Comment>(),city3);
			Restaurant restaurant4 = new Restaurant("Deustoarrak", "0", "0", "Basque", "", new ArrayList<Comment>(), city);
			Restaurant restaurant5 = new Restaurant("Foster", "0", "0", "American", "", new ArrayList<Comment>(),city);
			Restaurant restaurant6 = new Restaurant("MejicanoTere", "0", "0", "Mexican", "", new ArrayList<Comment>(), city);
//			Restaurant restaurant7 = new Restaurant("MejicanoTere", "0", "0", "Mexican", "", new ArrayList<Comment>(),city2);
//			Restaurant restaurant8 = new Restaurant("Smoking yewepe", "0", "0", "Asian", "", new ArrayList<Comment>(),city);
			Restaurant restaurant9 = new Restaurant("Smoking yewepe", "0", "0", "Asian", "", new ArrayList<Comment>(),city3);
			
			
			Member member = new Member("asd@asd","jon","jon",new ArrayList<Comment>());
			Member member2 = new Member("asd@asd","ana","ana",new ArrayList<Comment>());
			Member member3 = new Member("asd@asd","asier","asier",new ArrayList<Comment>());
			Member member4 = new Member("asd@asd","gorka","gorka",new ArrayList<Comment>());
			

			Comment comment = new Comment("Restaurante precioso", member, restaurant1);
			Comment comment2 = new Comment("Nos han hecho descuento por ser guapos", member2, restaurant4);
			Comment comment3 = new Comment("Me ha dado asco", member3, restaurant5);
			Comment comment4 = new Comment("Hay un pelo en la sopa", member4, restaurant6);
			Comment comment5 = new Comment("Una mierda", member, restaurant9);
			Comment comment6 = new Comment("Se come dpm", member2, restaurant1);
			
			//Get the Persistence Manager
			pm = pmf.getPersistenceManager();
			//Obtain the current transaction
			tx = pm.currentTransaction();		
			//Start the transaction
			tx.begin();

			System.out.println("Storing restaurants: ");

			pm.makePersistent(city);
			pm.makePersistent(city2);
			pm.makePersistent(city3);
			pm.makePersistent(restaurant1);
//			pm.makePersistent(restaurant2);
//			pm.makePersistent(restaurant3);
			pm.makePersistent(restaurant4);
			pm.makePersistent(restaurant5);
			pm.makePersistent(restaurant6);
//			pm.makePersistent(restaurant7);
//			pm.makePersistent(restaurant8);
			pm.makePersistent(restaurant9);

			pm.makePersistent(member);
			pm.makePersistent(member2);
			pm.makePersistent(member3);
			pm.makePersistent(member4);

			pm.makePersistent(comment);
			pm.makePersistent(comment2);
			pm.makePersistent(comment3);
			pm.makePersistent(comment4);
			pm.makePersistent(comment5);
			pm.makePersistent(comment6);
			

			//End the transaction
			tx.commit();	
			System.out.println("Data stored ok");
		} catch (Exception ex) {
			System.err.println(" $ Error storing objects in the DB: " + ex.getMessage());
			ex.printStackTrace();
		} finally {

			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
		}
	}


	public boolean storeComment(Comment comment) {
		boolean ok = false;
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			System.out.println("   * Storing a comment: " + comment);
			pm.makePersistent(comment);
			tx.commit();
			ok = true;
		} catch (Exception ex) {
			System.out.println("   $ Error storing an object: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
		return ok;
	}

	public boolean addRateToRestaurant(Restaurant restaurant, String newRate) {
		boolean ok = false;
		int newRate2 = Integer.parseInt(newRate);
		int mediaRates = Integer.parseInt(restaurant.getRate());
		int numRates = Integer.parseInt(restaurant.getNumRates());
		int newMediaRates = ((mediaRates * numRates) + newRate2) / (numRates + 1);
		restaurant.setRate(String.valueOf(newMediaRates));
		restaurant.setNumRates(String.valueOf((numRates) + 1));
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			System.out.println("   * Updating a restaurant (mediaRate): " + newMediaRates);

			pm.makePersistent(restaurant);
			tx.commit();
			ok = true;

		} catch (Exception ex) {
			System.out.println("Error updating a user: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
	    return ok;

	}
	@SuppressWarnings("finally")
	public MemberDTO retrieveMember(String name){
		Member m = new Member();
		MemberDTO memberDTO = new MemberDTO();
		try{
			System.out.println("INFO: Getting the member from the db: ");
			pm = pmf.getPersistenceManager();
			//Obtain the current transaction
			tx = pm.currentTransaction();		
			//Start the transaction
			tx.begin();				
			
			Extent<Member> extent = pm.getExtent(Member.class, true);
			for (Member member : extent) {
				System.out.println(member.getName());
				if(member.getName().equals(name)){
					System.out.println("ESTA DENTRO DEL IF");
					m = member;}
			}
			
			System.out.println(m.getName());
			System.out.println(m.getPassword());
			memberDTO = new MemberDTO(m.getName(), m.getPassword());
			
			tx.commit();
			System.out.println("Member retrieves successfully");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("WARN: Exception when retrieving from database");
		}finally{
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
		}
		return memberDTO;
	}
	
	public boolean addMember(String name, String password, String email){
		
		List<Comment> commentsM = new ArrayList<Comment>();
		Member member = new Member(email, name, password, commentsM);
		PersistenceManager pm = pmf.getPersistenceManager();
	    Transaction tx = pm.currentTransaction();
	    
	    try {
	    	tx.begin();
		       System.out.println("   * Updating a member: " + member.toString());

	    	pm.makePersistent(member);
	    	tx.commit();
	    	return true;
	     } catch (Exception ex) {
		   	System.out.println("Error updating a user: " + ex.getMessage());
		   	return false;
	     } finally {
		   	if (tx != null && tx.isActive()) {
		   		tx.rollback();
		   	}
				
	   		pm.close();
	     }
	}
	
	public List<Comment> getAllCommentsOfRestaurant(RestaurantDTO restaurantDTO) {
		List<Comment> r = new ArrayList<Comment>();
		try{
			System.out.println("INFO: Getting the comments from the db: ");
			pm = pmf.getPersistenceManager();
			//Obtain the current transaction
			tx = pm.currentTransaction();		
			//Start the transaction
			tx.begin();				
			
			Extent<Comment> extent = pm.getExtent(Comment.class, true);
			for (Comment comment : extent) {
				if(comment.getRestaurant().equals(restaurantDTO))
					r.add(comment);
					}

			tx.commit();
			System.out.println("Restaurant retrieves successfully");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("WARN: Exception when retrieving from database");
		}finally{
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
		}
		
		return r;
		}
	
	public boolean storeComment(String text, RestaurantDTO restaurant, Member member){
		Restaurant r = new Restaurant(restaurant.getNameR(),
									restaurant.getRate(),
									restaurant.getNumRates(),
									restaurant.getCategory(),
									restaurant.getStreet(),
									restaurant.getCommentsR(),
									restaurant.getCity());
		Comment comment = new Comment(text, member, r);
		PersistenceManager pm = pmf.getPersistenceManager();
	    Transaction tx = pm.currentTransaction();
	    
	    try {
	    	tx.begin();
		       System.out.println("   * Inserting a Comment into de Database " + member.toString());

	    	pm.makePersistent(comment);
	    	tx.commit();
	    	return true;
	     } catch (Exception ex) {
		   	System.out.println("Error updating a user: " + ex.getMessage());
		   	return false;
	     } finally {
		   	if (tx != null && tx.isActive()) {
		   		tx.rollback();
		   	}
				
	   		pm.close();
	     }
	}
		
}
