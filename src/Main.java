import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		    System.out.println("Please input number of avatar  :");
	        Scanner sc= new Scanner(System.in);
	        String avatar = sc.nextLine();
	        System.out.println("please input number of interests:");
	        String interests = sc.nextLine();
	        System.out.println("please input number of services:");
	        String services = sc.nextLine();
	        System.out.println("please input number of users:");
	        String users = sc.nextLine();
	        System.out.println("please input number of functionnalities:");
	        String func = sc.nextLine();
			try {
				copyHeader(new File("header2.owl"),new File("KB.owl"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

	        System.out.println("Avatars generation...");
	        float lStartTime = System.nanoTime();
	        ArrayList <AvatarProfile> avatars =new ArrayList<AvatarProfile>();
	        int port=3001;
	        int nb=0,c,l,nb1;
	        double radiusInDegrees,u,v,w,t,x,y,new_x;
	         radiusInDegrees = 2000f / 111000f;

	    	ThreadLocalRandom random = ThreadLocalRandom.current();
	        AvatarProfile tmp=null;
	        for (int i=0;i<Integer.parseInt(avatar);i++)
	        {
	        	tmp= new AvatarProfile();
	        	tmp.setUrl("http://localhost:"+port+"/");
	        	//System.out.println(port);
	        	/**************************Owner*****************/
	            tmp.setUserID(random.nextInt(1,Integer.parseInt(users))+1);
	            /******************services**********************/
	            nb=random.nextInt(2,9);
	            l=0;
	            while (l<nb)
	            {
	            	c=random.nextInt(1,Integer.parseInt(services)+1);
	            	if(!tmp.getServices().contains(c))
	            	{
	            		l++;
	            		tmp.getServices().add(c);
	            		//System.out.print(c+" ");
	            	}
	            	
	            }
	            /***************************Interests***************************/
	            System.out.println();
	            nb=random.nextInt(1,6);
	            double level;
	            l=0;
	            while (l<nb)
	            {
	            	c=random.nextInt(1,Integer.parseInt(interests)+1);
	            	if(!tmp.getInterests().contains(c))
	            	{
	            		l++;
	            		level=random.nextDouble(0,1);
	            		tmp.getInterestsLevel().add(level);
	            		tmp.getInterests().add(c);
	            		//System.out.print(c+" ");
	            	}
	            	
	            }
	            /************************Location********************************/
	             System.out.println();
	             u = random.nextDouble();
			     v = random.nextDouble();
			     w = radiusInDegrees * Math.sqrt(u);
			     t = 2 * Math.PI * v;
			     x = w * Math.cos(t);
			     y = w * Math.sin(t);

			    // Adjust the x-coordinate for the shrinking of the east-west distances
			     new_x = x / Math.cos(Math.toRadians(43.6043f));

			   tmp.setLon(new_x +  1.4437);
			   tmp.setLat(y +  43.6043);
	          // System.out.println("Longitude: " + tmp.getLon() + "  Latitude: " + tmp.getLat());
	           /********************************Process*****************************/
	           //generate grouped task
	           nb=random.nextInt(0,4);
	           if (nb==1)//generate a grouped task proba 1/4
	           {
	        		nb1=random.nextInt(1,Integer.parseInt(func)+1);
            		
            		tmp.getGoal().getGroupedTask().setFunction(nb1);
            		 
            		
	        	   nb=random.nextInt(2,7);
	        	   l=0;
	        	   while(l<nb)
	        	   {
	        		   c=random.nextInt(1,Integer.parseInt(services)+1);
		            	if(!tmp.getGoal().getGroupedTask().getAtomicTasks().contains(c))
		            	{
		            		l++;
		            		nb1=random.nextInt(1,Integer.parseInt(func)+1);
		            		/*while (tmp.getGoal().getGroupedTask().getFunctions().contains(nb1) || tmp.getGoal().getGroupedTask().getFunction()==nb1)
		            		{
			            		nb1=random.nextInt(1,Integer.parseInt(func)+1);

		            		 
		            		}*/
		            		tmp.getGoal().getGroupedTask().getFunctions().add(nb1);

		            	}
		            		tmp.getGoal().getGroupedTask().getAtomicTasks().add(c);
		            		//System.out.print(c+" ");
		            }
	        		   
	        	   }
	        	   nb=random.nextInt(0,2);
	        	   if (nb==0)
	        	   {
	        		   tmp.getGoal().getGroupedTask().setOperation("Parallel");

	        	   }
	        	   else
	        	   {
	        		   if (nb==1)
	        		   {
		        		   tmp.getGoal().getGroupedTask().setOperation("Choice");

	        			   
	        		   }
	        		   else
	        		   {
	        			   if(nb==2)
	        			   {
	    	        		   tmp.getGoal().getGroupedTask().setOperation("Sequence");

	        				   
	        			   }
	        		   }
	        	   }
	        	 

	        	   
	        	   
	           
	           //generate atomic tasks
	           nb=random.nextInt(1,16);
        	   l=0;
        	   while(l<nb)
        	   {
        		   c=random.nextInt(1,Integer.parseInt(services)+1);
	            	if(!tmp.getGoal().getAtomictasks().contains(c))
	            	{
	            		l++;
	            		nb1=random.nextInt(1,Integer.parseInt(func)+1);

	            		/*while (tmp.getGoal().getGroupedTask().getFunctions().contains(nb1) || tmp.getGoal().getGroupedTask().getFunction()==nb1 || tmp.getGoal().getFunctions().contains(nb))
	            		{
		            		nb1=random.nextInt(1,Integer.parseInt(func)+1);

	            	 

	            		}*/
	            		tmp.getGoal().getFunctions().add(nb1);

	            		tmp.getGoal().getAtomictasks().add(c);
	            		//System.out.print(c+" ");
	            	}
        		   
        	   }
        	   nb=random.nextInt(0,3);
        	   if (nb==0)
        	   {
        		   tmp.getGoal().setOperation("Parallel");

        	   }
        	   else
        	   {
        		   if (nb==1)
        		   {
            		   tmp.getGoal().setOperation("Choice");

        			   
        		   }
        		   else
        		   {
        			   if(nb==2)
        			   {
                		   tmp.getGoal().setOperation("Sequence");

        				   
        			   }
        		   }
        	   }
        	 
        	   //fill semanticfile
   	      try {
   				copyHeader(new File("header.owl"),new File("avatar"+port+".owl"));
   				FillFile(new File("avatar"+port+".owl"),tmp,port);
   				copyHeader(new File("footer.owl"),new File("avatar"+port+".owl"));


   			} catch (IOException e) {
   				// TODO Auto-generated catch block
   				System.out.print("hhh");
   				e.printStackTrace();
   			}
   	        port++;
	        }
	        float lEndTime = System.nanoTime();
	        float output = lEndTime - lStartTime;

	        System.out.println("Elapsed time in milliseconds: " + output / 1000000f);
	        
	        //THE END 
	        try {
				copyHeader(new File("footer2.owl"),new File("KB.owl"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    
	}
	    

		   
	        



	 
	   
	private static void copyHeader(File source, File dest) throws IOException {
	    InputStream is = null;
	    OutputStream os = null;
	    try {
	        is = new FileInputStream(source);
	        os = new FileOutputStream(dest,true);
	        byte[] buffer = new byte[1024];
	        int length;
	        while ((length = is.read(buffer)) > 0) {
	            os.write(buffer, 0, length);
	        }
	 
	  
	    } finally {
	        is.close();
	    	
	        os.close();
	    }	
             
	        	 
	         
	       
	   
	}
	private static void FillFile(File dest,AvatarProfile tmp,int port) throws IOException {
	 
	        	 
	        OutputStream  os = new FileOutputStream(dest,true);
	        OutputStream  kb = new FileOutputStream("KB.owl",true);

 	            int i;
	        	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
	        	BufferedWriter bwKb = new BufferedWriter(new OutputStreamWriter(kb));

	        	bw.newLine();
	        	bwKb.newLine();
	        	 /************************Avatar****************/
	        		bw.write("<owl:NamedIndividual rdf:about=\"http://www.laas-cnrs.fr/recherches/SARA/ontologies/AvatarOnt#Avatar"+port+"\">");
	        		bw.newLine();
	        		bwKb.write("<owl:NamedIndividual rdf:about=\"http://www.laas-cnrs.fr/recherches/SARA/ontologies/AvatarOnt#Avatar"+port+"\">");
	        		bwKb.newLine();
	        		bw.write("<rdf:type rdf:resource=\"http://www.laas-cnrs.fr/recherches/SARA/ontologies/AvatarOnt#Avatar\"/>");
	        		bw.newLine();
	        		bwKb.write("<rdf:type rdf:resource=\"http://www.laas-cnrs.fr/recherches/SARA/ontologies/AvatarOnt#Avatar\"/>");
	        		bwKb.newLine();
	        		bw.write("<hasGoal rdf:resource=\"http://www.laas-cnrs.fr/recherches/SARA/ontologies/AvatarOnt#Goal"+port+"\"/>");
	        		bw.newLine();
	        		for(i=0;i<tmp.getServices().size();i++)
	        			
	        		{
	        		bw.write("<hasService rdf:resource=\"http://www.laas-cnrs.fr/recherches/SARA/ontologies/AvatarOnt#Service"+tmp.getServices().get(i)+"\"/>");
	        		bw.newLine();
	        		}
	        		for(i=0;i<tmp.getInterests().size();i++)
	        		{
	        			 
	        			bw.write("<hasInterest rdf:datatype=\"http://www.w3.org/2001/XMLSchema#string\">Interest"+tmp.getInterests().get(i)+"/"+tmp.getInterestsLevel().get(i)+"</hasInterest>");
		        		bw.newLine();
		        		bwKb.write("<hasInterest rdf:datatype=\"http://www.w3.org/2001/XMLSchema#string\">Interest"+tmp.getInterests().get(i)+"/"+tmp.getInterestsLevel().get(i)+"</hasInterest>");
		        		bwKb.newLine();
	        		}
	        		bw.write("<hasOwner rdf:datatype=\"http://www.w3.org/2001/XMLSchema#string\">Owner"+tmp.getUserID()+"</hasOwner>");
	        		bw.newLine();
	        		bw.write("<hasLocation rdf:datatype=\"http://www.w3.org/2001/XMLSchema#string\">"+tmp.getLon()+"/"+tmp.getLat()+"</hasLocation>");
	        		bw.newLine();
	        		
	        		bwKb.write("<hasOwner rdf:datatype=\"http://www.w3.org/2001/XMLSchema#string\">Owner"+tmp.getUserID()+"</hasOwner>");
	        		bwKb.newLine();
	        		bwKb.write("<hasLocation rdf:datatype=\"http://www.w3.org/2001/XMLSchema#string\">"+tmp.getLon()+"/"+tmp.getLat()+"</hasLocation>");
	        		bwKb.newLine();
	        		bw.write("<represents rdf:resource=\"http://www.laas-cnrs.fr/recherches/SARA/ontologies/AvatarOnt#Left_blinking\"/>");
	        		bw.newLine();
	        		bw.write("<deployedIn rdf:datatype=\"http://www.w3.org/2001/XMLSchema#anyURI\">"+tmp.getUrl()+"</deployedIn>");
	        		bw.newLine();
	        		bwKb.write("<deployedIn rdf:datatype=\"http://www.w3.org/2001/XMLSchema#anyURI\">"+tmp.getUrl()+"</deployedIn>");
	        		bwKb.newLine();
	        		bw.write("<hasMobility rdf:datatype=\"http://www.w3.org/2001/XMLSchema#boolean\">true</hasMobility>");
	        		bw.newLine();
	        		bw.write("</owl:NamedIndividual>");
	        		bw.newLine();
	        		
	        		bwKb.write("</owl:NamedIndividual>");
	        		bwKb.newLine();
	        		/****************Process***********************/
	        		bw.write("<owl:NamedIndividual rdf:about=\"http://www.laas-cnrs.fr/recherches/SARA/ontologies/AvatarOnt#Goal"+port+"\">");
	        		bw.newLine();
	        		bw.write("<rdf:type rdf:resource=\"http://www.semanticweb.org/kkhadir/ontologies/2019/1/DEMISA#GroupedTask\"/>");
	        		bw.newLine();
	        		bw.write("<hasLabel rdf:datatype=\"http://www.w3.org/2001/XMLSchema#string\">LabelG"+port+"</hasLabel>");
	        		bw.newLine();
	        		 
	        		if(tmp.getGoal().getGroupedTask().getAtomicTasks().size()>0)//we have grouped task
	        		{
	        			bw.write("<hasChildTask rdf:resource=\"http://www.laas-cnrs.fr/recherches/SARA/ontologies/AvatarOnt#Task"+port+"\"/>");
		        		bw.newLine();
	        		}
	        		for(i=0;i<tmp.getGoal().getAtomictasks().size();i++)
	        		{
	        			bw.write("<hasChildTask rdf:resource=\"http://www.laas-cnrs.fr/recherches/SARA/ontologies/AvatarOnt#Task"+tmp.getGoal().getAtomictasks().get(i)+"\"/>");
		        		bw.newLine();
	        		}
	        		bw.write("<DEMISA:hasGrouping rdf:resource=\"http://www.laas-cnrs.fr/recherches/SARA/ontologies/AvatarOnt#"+tmp.getGoal().getOperation()+"\"/>");
	        		bw.newLine();
	        		bw.write("</owl:NamedIndividual>");
	        		bw.newLine();
	        		
		        	 /************************Tasks****************/
	        		if(tmp.getGoal().getGroupedTask().getAtomicTasks().size()>0)//we have grouped task
	        		{
	        			bw.write("<owl:NamedIndividual rdf:about=\"http://www.laas-cnrs.fr/recherches/SARA/ontologies/AvatarOnt#Task"+port+"\">");
		        		bw.newLine();
		        		bw.write("<rdf:type rdf:resource=\"http://www.semanticweb.org/kkhadir/ontologies/2019/1/DEMISA#GroupedTask\"/>");
		        		bw.newLine();
		        		bw.write("<hasLabel rdf:datatype=\"http://www.w3.org/2001/XMLSchema#string\">Label"+port+"</hasLabel>");
		        		bw.newLine();
		        		bw.write("<hasFunction rdf:datatype=\"http://www.w3.org/2001/XMLSchema#string\">Function"+tmp.getGoal().getGroupedTask().getFunction()+"</hasFunction>");
		        		bw.newLine();
		        		for(i=0;i<tmp.getGoal().getGroupedTask().getAtomicTasks().size();i++)
		        		{
		        			bw.write("<hasChildTask rdf:resource=\"http://www.laas-cnrs.fr/recherches/SARA/ontologies/AvatarOnt#Task"+tmp.getGoal().getGroupedTask().getAtomicTasks().get(i)+"\"/>");
			        		bw.newLine();
		        		}
		        		bw.write("<DEMISA:hasGrouping rdf:resource=\"http://www.laas-cnrs.fr/recherches/SARA/ontologies/AvatarOnt#"+tmp.getGoal().getGroupedTask().getOperation()+"\"/>");
		        		bw.newLine();
		        		bw.write("</owl:NamedIndividual>");
		        		bw.newLine();
		        		for(i=0;i<tmp.getGoal().getGroupedTask().getAtomicTasks().size();i++)
		        		{
		        			bw.write("<owl:NamedIndividual rdf:about=\"http://www.laas-cnrs.fr/recherches/SARA/ontologies/AvatarOnt#Task"+tmp.getGoal().getGroupedTask().getAtomicTasks().get(i)+"\">");
			        		bw.newLine();
			        		bw.write("<rdf:type rdf:resource=\"http://www.semanticweb.org/kkhadir/ontologies/2019/1/DEMISA#AtomicTask\"/>");
			        		bw.newLine();
			        		bw.write("<hasLabel rdf:datatype=\"http://www.w3.org/2001/XMLSchema#string\">Label"+tmp.getGoal().getGroupedTask().getAtomicTasks().get(i)+"</hasLabel>");
			        		bw.newLine();
			        		bw.write("<hasFunction rdf:datatype=\"http://www.w3.org/2001/XMLSchema#string\">Function"+tmp.getGoal().getGroupedTask().getAtomicTasks().get(i)+"</hasFunction>");
			        		bw.newLine();
			        		bw.write("<hasInput rdf:datatype=\"http://www.w3.org/2001/XMLSchema#string\">x</hasInput>");
			        		bw.newLine();
			        		bw.write("<hasOutput rdf:datatype=\"http://www.w3.org/2001/XMLSchema#boolean\">false</hasOutput>");
			        		bw.newLine();
			        		bw.write("<hasPrecondition rdf:datatype=\"http://www.w3.org/2001/XMLSchema#string\">TimeExec&lt;2</hasPrecondition>");
			        		bw.newLine();
			        		bw.write("</owl:NamedIndividual>");
			        		bw.newLine();
		        		}
	        		}
	        		for(i=0;i<tmp.getGoal().getAtomictasks().size();i++)
	        		{
	        			bw.write("<owl:NamedIndividual rdf:about=\"http://www.laas-cnrs.fr/recherches/SARA/ontologies/AvatarOnt#Task"+tmp.getGoal().getAtomictasks().get(i)+"\">");
		        		bw.newLine();
		        		bw.write("<rdf:type rdf:resource=\"http://www.semanticweb.org/kkhadir/ontologies/2019/1/DEMISA#AtomicTask\"/>");
		        		bw.newLine();
		        		bw.write("<hasLabel rdf:datatype=\"http://www.w3.org/2001/XMLSchema#string\">Label"+tmp.getGoal().getAtomictasks().get(i)+"</hasLabel>");
		        		bw.newLine();
		        		bw.write("<hasFunction rdf:datatype=\"http://www.w3.org/2001/XMLSchema#string\">Function"+tmp.getGoal().getFunctions().get(i)+"</hasFunction>");
		        		bw.newLine();
		        		bw.write("<hasInput rdf:datatype=\"http://www.w3.org/2001/XMLSchema#string\">x</hasInput>");
		        		bw.newLine();
		        		bw.write("<hasOutput rdf:datatype=\"http://www.w3.org/2001/XMLSchema#boolean\">false</hasOutput>");
		        		bw.newLine();
		        		bw.write("<hasPrecondition rdf:datatype=\"http://www.w3.org/2001/XMLSchema#string\">TimeExec&lt;2</hasPrecondition>");
		        		bw.newLine();
		        		bw.write("</owl:NamedIndividual>");
		        		bw.newLine();
	        		}
	        		/***********************Services************************/
	        		for (i=0;i<tmp.getServices().size();i++)
	        		{
	        			bw.write("<owl:NamedIndividual rdf:about=\"http://www.laas-cnrs.fr/recherches/SARA/ontologies/AvatarOnt#Service"+tmp.getServices().get(i)+"\">");
		        		bw.newLine();
		        		bw.write("<rdf:type rdf:resource=\"http://iserve.kmi.open.ac.uk/ns/msm#Service\"/>");
		        		bw.newLine();
		        		bw.write("<hasQoS rdf:resource=\"http://www.laas-cnrs.fr/recherches/SARA/ontologies/AvatarOnt#Service"+tmp.getServices().get(i)+"_QoS\"/>");
		        		bw.newLine();
		        		bw.write("<msm:hasOperation rdf:resource=\"http://www.laas-cnrs.fr/recherches/SARA/ontologies/AvatarOnt#Service"+tmp.getServices().get(i)+"_operation\"/>");
		        		bw.newLine();
		        		bw.write("<hasLabel rdf:datatype=\"http://www.w3.org/2001/XMLSchema#string\">Label"+tmp.getServices().get(i)+"</hasLabel>");
		        		bw.newLine();
		        		bw.write("</owl:NamedIndividual>");
		        		bw.newLine();
		        		bw.write("<owl:NamedIndividual rdf:about=\"http://www.laas-cnrs.fr/recherches/SARA/ontologies/AvatarOnt#Service"+tmp.getServices().get(i)+"_QoS\">");
		        		bw.newLine();
		        		bw.write("<rdf:type rdf:resource=\"http://www.laas-cnrs.fr/recherches/SARA/ontologies/AvatarOnt#QoS\"/>");
		        		bw.newLine();
		        		bw.write("<hasPerformance rdf:resource=\"http://www.laas-cnrs.fr/recherches/SARA/ontologies/AvatarOnt#Service"+tmp.getServices().get(i)+"_performance\"/>");
		        		bw.newLine();
		        		bw.write("</owl:NamedIndividual>");
		        		bw.newLine();
		        		
		        		bw.write("<owl:NamedIndividual rdf:about=\"http://www.laas-cnrs.fr/recherches/SARA/ontologies/AvatarOnt#Service"+tmp.getServices().get(i)+"_operation\">");
		        		bw.newLine();
		        		bw.write("<rdf:type rdf:resource=\"http://iserve.kmi.open.ac.uk/ns/msm#Operation\"/>");
		        		bw.newLine();
		        		bw.write("<hasAddress rdf:datatype=\"http://www.w3.org/2001/XMLSchema#anyURI\"></hasAddress>");
		        		bw.newLine();
		        		bw.write("<hasMethod rdf:datatype=\"http://www.w3.org/2001/XMLSchema#string\">GET</hasMethod>");
		        		bw.newLine();
		        		bw.write("<hasOutputMessage rdf:datatype=\"http://www.w3.org/2001/XMLSchema#string\">OutputOFService"+tmp.getServices().get(i)+"</hasOutputMessage>");
		        		bw.newLine();
		        		bw.write("</owl:NamedIndividual>");
		        		bw.newLine();
		        		
		        		bw.write("<owl:NamedIndividual rdf:about=\"http://www.laas-cnrs.fr/recherches/SARA/ontologies/AvatarOnt#Service"+tmp.getServices().get(i)+"_performance\">");
		        		bw.newLine();
		        		bw.write("<rdf:type rdf:resource=\"http://www.laas-cnrs.fr/recherches/SARA/ontologies/AvatarOnt#Performance\"/>");
		        		bw.newLine();
		        		bw.write("<hasAvailability rdf:datatype=\"http://www.w3.org/2001/XMLSchema#boolean\">true</hasAvailability>");
		        		bw.newLine();
		        		bw.write("<hasExecTime rdf:datatype=\"http://www.w3.org/2001/XMLSchema#double\">0.1</hasExecTime>");
		        		bw.newLine();
		        		bw.write("<hasTotalCalls rdf:datatype=\"http://www.w3.org/2001/XMLSchema#integer\">0</hasTotalCalls>");
		        		bw.newLine();
		        		bw.write("</owl:NamedIndividual>");
		        		bw.newLine();
		        		
		        		
		        		
	        		}
	        		bw.close();
	        		bwKb.close();
	        		os.close();
	     	
             
	        	 
	         
	       
	   
	}
  

}
