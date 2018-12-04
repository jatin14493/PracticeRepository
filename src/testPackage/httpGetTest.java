package testPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;


class status{

    public String name;
    public String company;
    public String blog;
    public String location;
    public String email;

    public status(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}


// https://api.github.com/users/jatin14493
public class httpGetTest {

    public static void main(String[] args) throws IOException {

        status status = new status();
        String url = "https://api.github.com/users/jatin14493";
        HashMap<String,String> hmap = new HashMap<>();
        hmap.put("user","jatin14493");
        status = doGet(status ,url , hmap);
        System.out.println(status);
    }


    public static <T> T doGet(status res, String requestUrl, HashMap<String, String> hmap) throws IOException {

        StringBuilder result = new StringBuilder();
        URL url = new URL(requestUrl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/json");
//        for (Map.Entry<String, String> entry : hmap.entrySet()) {
//            con.setRequestProperty(entry.getKey(), entry.getValue());
//        }


        String readLine = null;
        StringBuffer response = new StringBuffer();
        int responseCode = con.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));

            while ((readLine = in .readLine()) != null) {
                response.append(readLine);
            } in .close();
            System.out.println("JSON String Result " + response.toString());
        } else {
            System.out.println("GET NOT WORKED");
        }


        T responseObj = null;
        SerializationMode mode = null;
        mode = SerializationMode.JSON;


//        try {
//            ObjectMapper mapper = new ObjectMapper();
//            user = mapper.readValue(result, Developer.class);
//            item = user.getItems();
//        } catch (Exception ex) {
//            System.out.println("Exception parsing the object");
//        }

        return responseObj;

    }
}



