package entity;

import java.io.FileNotFoundException; // Import this class to handle errors
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class EnemyList extends Enemy
{
	//public Enemy enemyData = new Enemy();
	public Enemy enemyData[] = new Enemy[10];
	private int count = 0;
	
	//public static void main(String[] args)
	@SuppressWarnings("unchecked")
	public void enemyData(/*int id*/) 
	{
		//int id = 1;
		JSONParser parser = new JSONParser();

		try (FileReader reader = new FileReader("enemy.json")) 
		{
			Object obj = parser.parse(reader);

			JSONArray enemyArray = (JSONArray) obj;
			//parseEnemy((JSONObject) enemyArray.get(id));
			enemyArray.forEach( emp -> parseEnemy( (JSONObject) emp ) );

		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} catch (IOException e) 
		{
			e.printStackTrace();
		} catch (ParseException e) 
		{
			e.printStackTrace();
		}
	}
	
	private void parseEnemy(JSONObject enemy) 
    {
        JSONObject enemyObject = (JSONObject) enemy.get("enemy");
        
        /*this.enemyData = new Enemy((String) enemyObject.get("name"), 
        		(int) Integer.parseInt((String) enemyObject.get("attack")), 
        		(String) enemyObject.get("description"), 
        		(int) Integer.parseInt((String) enemyObject.get("item")),
        		(int) Integer.parseInt((String) enemyObject.get("basehp")),
        		(int) Integer.parseInt((String) enemyObject.get("basexp")));*/
        
        this.enemyData[count] = new Enemy((String) enemyObject.get("name"), 
        		(int) Integer.parseInt((String) enemyObject.get("attack")), 
        		(String) enemyObject.get("description"), 
        		(int) Integer.parseInt((String) enemyObject.get("item")),
        		(int) Integer.parseInt((String) enemyObject.get("basehp")),
        		(int) Integer.parseInt((String) enemyObject.get("basexp")),
        		(int) Integer.parseInt((String) enemyObject.get("loot")));
        count ++;
        //enemyData.toString();
        /*long endTime = System.nanoTime();
        System.out.println("Took "+(endTime - startTime) + " ns"); */
    }
	
	public int getCount()
	{
		return this.count;
	}
}
