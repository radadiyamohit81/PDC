import java.net.*;
import java.io.*;
public class Client
{
	public static void main(String []args) throws Exception
	{
		Socket s2 = new Socket("127.0.0.1",9000);
		BufferedReader sbr = new BufferedReader(new InputStreamReader(System.in));
		OutputStream os = s2.getOutputStream();
		PrintWriter pw = new PrintWriter(os,true);
		InputStream is = s2.getInputStream();
		BufferedReader rbr=new BufferedReader(new InputStreamReader(is));
		System.out.println("Start the chat...");
		String rmsg,smsg;
		while(true)
		{
			smsg=sbr.readLine();
			pw.println(smsg);
			pw.flush();
			if((rmsg=rbr.readLine())!=null)
			{
				System.out.println("\nServer Says : "+rmsg);
			}
		}
	}
}