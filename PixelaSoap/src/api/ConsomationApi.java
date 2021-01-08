package api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ConsomationApi {
	//-------------------------------------------------------USER-----------------------------------------------------------------------------------
	
	public String creatUser(String token, String username, String ATOS, String notMinor) {
		String post_params = "{\"token\":\""+token+"\", \"username\":\""+username+"\", \"agreeTermsOfService\":\""+ATOS+"\", \"notMinor\":\""+notMinor+"\", \"thanksCode\":\"ThisIsThanksCode\"}";
		try {
			System.out.println(post_params);

			URL url = new URL("https://pixe.la/v1/users");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Accept", "application/json");
			conn.setDoOutput(true);

			conn.getOutputStream().write(post_params.getBytes());
			conn.getOutputStream().flush();
			conn.getOutputStream().close();

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;
			String response = "";
			System.out.println("reponse de Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
				response += output;
			}

			conn.disconnect();
			return response;
		} catch (MalformedURLException e) {

			e.printStackTrace();
			return null;
		} catch (IOException e) {

			e.printStackTrace();
			return null;

		}

	}
	public String updateUser(String token,String newToken,String username) {
		String post_params = "{\"newToken\":\""+newToken+"\",\"thanksCode\":\"ThisIsThanksCode\"}";
		try {
			System.out.println(post_params);

			URL url = new URL("https://pixe.la/v1/users/"+username);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("PUT");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("X-USER-TOKEN", token);
			conn.setDoOutput(true);

			conn.getOutputStream().write(post_params.getBytes());
			conn.getOutputStream().flush();
			conn.getOutputStream().close();

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;
			String response = "";
			System.out.println("reponse de Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
				response += output;
			}

			conn.disconnect();
			return response;
		} catch (MalformedURLException e) {

			e.printStackTrace();
			return null;
		} catch (IOException e) {

			e.printStackTrace();
			return null;

		}

	}
	public String deleteUser(String token,String username) {
		try {

			URL url = new URL("https://pixe.la/v1/users/"+username);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("DELETE");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("X-USER-TOKEN", token);
			conn.setDoOutput(true);

			conn.getOutputStream().write("".getBytes());
			conn.getOutputStream().flush();
			conn.getOutputStream().close();

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;
			String response = "";
			System.out.println("reponse de Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
				response += output;
			}

			conn.disconnect();
			return response;
		} catch (MalformedURLException e) {

			e.printStackTrace();
			return null;
		} catch (IOException e) {

			e.printStackTrace();
			return null;

		}

	}
	public void showUserProfil(String username) {
		Runtime rt = Runtime.getRuntime();
		String url = "https://pixe.la/@"+username;
		try {
			rt.exec("rundll32 url.dll,FileProtocolHandler " + url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//-------------------------------------------------------GRAPH-----------------------------------------------------------------------------------
	
	public String creatGraph(String token, String id, String name, String unit,String color,String username) {
		String post_params = "{\"id\":\""+id+"\",\"name\":\""+name+"\",\"unit\":\""+unit+"\",\"type\":\"int\",\"color\":\""+color+"\",\"timezone\":\"Asia/Tokyo\",\"isSecret\":true,\"publishOptionalData\":true}";
		try {
			System.out.println(post_params);

			URL url = new URL("https://pixe.la/v1/users/"+username+"/graphs");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("X-USER-TOKEN",token);

			conn.setDoOutput(true);
			

			conn.getOutputStream().write(post_params.getBytes());
			conn.getOutputStream().flush();
			conn.getOutputStream().close();

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;
			String response = "";
			System.out.println("reponse de Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
				response += output;
			}

			conn.disconnect();
			return response;
		} catch (MalformedURLException e) {

			e.printStackTrace();
			return null;
		} catch (IOException e) {

			e.printStackTrace();
			return null;

		}
	}
	public String getAllGraph(String username,String token) {
		try {
			URL url = new URL("https://pixe.la/v1/users/"+username+"/graphs");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("X-USER-TOKEN",token);

			conn.setDoOutput(true);

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;
			String response = "";
			System.out.println("reponse de Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
				response += output;
			}

			conn.disconnect();
			return response;
		} catch (MalformedURLException e) {

			e.printStackTrace();
			return null;
		} catch (IOException e) {

			e.printStackTrace();
			return null;

		}
	}
	public String updateGraph(String token, String id, String name, String unit,String color,String username) {
		String post_params = "{\"name\":\""+name+"\",\"unit\":\""+unit+"\",\"color\":\""+color+"\",\"timezone\":\"Asia/Tokyo\",\"purgeCacheURLs\":[\"https://camo.githubusercontent.com/xxx/xxxx\"],\"publishOptionalData\":true}";
		try {
			System.out.println(post_params);

			URL url = new URL("https://pixe.la/v1/users/"+username+"/graphs/"+id);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("PUT");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("X-USER-TOKEN",token);

			conn.setDoOutput(true);
			

			conn.getOutputStream().write(post_params.getBytes());
			conn.getOutputStream().flush();
			conn.getOutputStream().close();

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;
			String response = "";
			System.out.println("reponse de Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
				response += output;
			}

			conn.disconnect();
			return response;
		} catch (MalformedURLException e) {

			e.printStackTrace();
			return null;
		} catch (IOException e) {

			e.printStackTrace();
			return null;

		}
	}
	
	public String deletGraph(String id,String username,String token) {
		try {
			URL url = new URL("https://pixe.la/v1/users/"+username+"/graphs/"+id);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("DELETE");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("X-USER-TOKEN",token);

			conn.setDoOutput(true);
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;
			String response = "";
			System.out.println("reponse de Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
				response += output;
			}

			conn.disconnect();
			return response;
		} catch (MalformedURLException e) {

			e.printStackTrace();
			return null;
		} catch (IOException e) {

			e.printStackTrace();
			return null;

		}
	}
	//-------------------------------------------------------PIXEL-----------------------------------------------------------------------------------
	
		public String creatPixel(String token, String id, String username, String date,String quantity) {
			String post_params = "{\"date\":\""+date+"\",\"quantity\":\""+quantity+"\",\"optionalData\":\"{\\\"key\\\":\\\"value\\\"}\"}";
			try {
				System.out.println(post_params);

				URL url = new URL("https://pixe.la/v1/users/"+username+"/graphs/"+id);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("POST");
				conn.setRequestProperty("Accept", "application/json");
				conn.setRequestProperty("X-USER-TOKEN",token);

				conn.setDoOutput(true);
				

				conn.getOutputStream().write(post_params.getBytes());
				conn.getOutputStream().flush();
				conn.getOutputStream().close();

				if (conn.getResponseCode() != 200) {
					throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
				}

				BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

				String output;
				String response = "";
				System.out.println("reponse de Server .... \n");
				while ((output = br.readLine()) != null) {
					System.out.println(output);
					response += output;
				}

				conn.disconnect();
				return response;
			} catch (MalformedURLException e) {

				e.printStackTrace();
				return null;
			} catch (IOException e) {

				e.printStackTrace();
				return null;

			}
		}
		
			public String getPixelsGraph(String token, String id, String username, String date,String date1) {
				try {
				URL url = new URL("https://pixe.la/v1/users/"+username+"/graphs/"+id+"/pixels?withBody=true&from="+date+"&to="+date1);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Accept", "application/json");
				conn.setRequestProperty("X-USER-TOKEN",token);
				
				conn.setDoOutput(true);
				
				if (conn.getResponseCode() != 200) {
					throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
				}
				BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

				String output;
				String response = "";
				System.out.println("reponse de Server .... \n");
				while ((output = br.readLine()) != null) {
					System.out.println(output);
					response += output;
				}

				conn.disconnect();
				return response;
			} catch (MalformedURLException e) {

				e.printStackTrace();
				return null;
			} catch (IOException e) {

				e.printStackTrace();
				return null;

			}
		}
		public String getPixel(String token, String id, String username, String date) {
			try {

				URL url = new URL("https://pixe.la/v1/users/"+username+"/graphs/"+id+"/pixels?withBody=true&from="+date);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Accept", "application/json");
				conn.setRequestProperty("X-USER-TOKEN",token);
                conn.setDoOutput(true);
			
				if (conn.getResponseCode() != 200) {
					throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
				}
				BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
				String output;
				String response = "";
				System.out.println("reponse de Server .... \n");
				while ((output = br.readLine()) != null) {
					System.out.println(output);
					response += output;
				}

				conn.disconnect();
				return response;
			} catch (MalformedURLException e) {

				e.printStackTrace();
				return null;
			} catch (IOException e) {

				e.printStackTrace();
				return null;

			}
		}
		public String deletpixel(String id,String username,String token,String date) {
			try {
				URL url = new URL("https://pixe.la/v1/users/"+username+"/graphs/"+id+"/"+date);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("DELETE");
				conn.setRequestProperty("Accept", "application/json");
				conn.setRequestProperty("X-USER-TOKEN",token);

				conn.setDoOutput(true);
				if (conn.getResponseCode() != 200) {
					throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
				}
				BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

				String output;
				String response = "";
				System.out.println("reponse de Server .... \n");
				while ((output = br.readLine()) != null) {
					System.out.println(output);
					response += output;
				}

				conn.disconnect();
				return response;
			} catch (MalformedURLException e) {

				e.printStackTrace();
				return null;
			} catch (IOException e) {

				e.printStackTrace();
				return null;

			}
		}
		public String updatePixel(String token, String id, String username, String date,String quantity,String data) {
			String post_params = "{\"quantity\":\""+quantity+"\",\"optionalData\":\"{\\\"key\\\":\\\"value\\\"}\"}";
			try {
				System.out.println(post_params);

				URL url = new URL("https://pixe.la/v1/users/"+username+"/graphs/"+id+"/"+date);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("PUT");
				conn.setRequestProperty("Accept", "application/json");
				conn.setRequestProperty("X-USER-TOKEN",token);

				conn.setDoOutput(true);
				
				conn.getOutputStream().write(post_params.getBytes());
				conn.getOutputStream().flush();
				conn.getOutputStream().close();

				if (conn.getResponseCode() != 200) {
					throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
				}

				BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

				String output;
				String response = "";
				System.out.println("reponse de Server .... \n");
				while ((output = br.readLine()) != null) {
					System.out.println(output);
					response += output;
				}

				conn.disconnect();
				return response;
			} catch (MalformedURLException e) {

				e.printStackTrace();
				return null;
			} catch (IOException e) {

				e.printStackTrace();
				return null;

			}
		}
}
