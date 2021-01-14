package stepdefinitions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.WriteResult;

import io.restassured.path.json.JsonPath;

public class MongoDBConnections {

	public static void main(String[] args) {

		MongoClient mongoClient = new MongoClient("localhost", 27017); // should use this always

		DB db = mongoClient.getDB("MyTest");
		DBCollection collection = db.getCollection("posts");
		System.out.println("records count is"+ collection.count());
		BasicDBObject dbobject = new BasicDBObject();
		dbobject.append("name", "gopinath Shetty Academy");
		dbobject.append("accuracy", 50);
		System.out.println("values in dbobject are : "+dbobject);				
		//MongoCredential mc = MongoCredential.createCredential("admin", "admin", "abc123".toCharArray());
		//ServerAddress sc = new ServerAddress("localhost", 27017);
		//MongoClient mongoclient = new MongoClient(sc, Arrays.asList(mc));
		DBCursor cursor = collection.find(dbobject);
		// System.out.println("cursor value is"+ cursor);
		System.out.println("count is" + cursor.count());
		while (cursor.hasNext()) {
			
			DBObject object = cursor.next();
			JsonPath js = new JsonPath(object.toString());
			System.out.println(js.prettify());
		}
		BasicDBObject dbobj = new BasicDBObject();
		
		/*
		 * dbobj.append("name", "gopi"); dbobj.put("age", 20);
		 */
		//collection.insert(dbobj);
	
		
		HashMap<String,Object> hmap = new HashMap<String,Object>();
		
		hmap.put("city", "ajman");
		hmap.put("landmark", 123);
        HashMap<String,Object> hmap2 = new HashMap<String,Object>();
		
		hmap2.put("name", "hello");
		hmap2.put("age", 123);
		hmap.put("address", hmap2);
		System.out.println("hmap2 is" + hmap2);
		hmap.putAll(hmap2);
		
		System.out.println("hmap is "+ hmap);
		//collection.insert(new BasicDBObject(hmap));
		BasicDBObject dbobjs = new BasicDBObject();
		ArrayList<String> al = new ArrayList<String>();
		al.add("dubai");
		al.add("ajman");
		//collection.remove(new BasicDBObject("city", "dubai"));
		dbobjs.put("city", new BasicDBObject("$in", al));
		//collection.insert(dbobjs);
		WriteResult wr =collection.remove(dbobjs);
		System.out.println("deleted records are "+wr.getN());
		
		// insert
		BasicDBObject basicdb = new BasicDBObject();
		basicdb.append("name", "gopi");
		basicdb.append("age", 00);
		BasicDBObject basicdbobj = new BasicDBObject();
		basicdbobj.append("area", "earth");
		basicdbobj.append("phone", 123456);
		basicdb.append("info", basicdbobj);
		collection.insert(basicdb);
		
		
		mongoClient.close();
		System.out.println("connection closed");

	}
	
	// insert a document, remove a docuemnt

}
