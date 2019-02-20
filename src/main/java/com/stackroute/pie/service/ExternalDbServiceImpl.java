package com.stackroute.pie.service;

import com.mongodb.*;
import com.mongodb.util.JSON;
import com.stackroute.pie.domain.Policy;
import com.stackroute.pie.repository.ExternalDbRepository;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.sql.*;
import java.util.List;
import java.util.Scanner;

@Service
public class ExternalDbServiceImpl implements ExternalDbService {


    @Autowired
    public ExternalDbServiceImpl(ExternalDbRepository externalDbRepository) {
        this.externalDbRepository = externalDbRepository;
    }

    private ExternalDbRepository externalDbRepository;


    @Override
    public List<Policy> getPolicies(String insurerName) throws ClassNotFoundException, SQLException, UnsupportedEncodingException, JSONException {

        List<Policy> p = null;
        String origFile = null;

        String dbURL = "jdbc:mysql://172.23.239.178:3306/insurerFinal";
        String dbUser = "fish";
        String dbPass = "12345";

        Class.forName("com.mysql.cj.jdbc.Driver");
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPass);


        Statement st = conn.createStatement();

        Blob xmlfile = null;

        ResultSet rs = st.executeQuery("Select * from MaxBupa");
        // System.out.println(rs.first()+";;;;;;;;");
        byte[] bdata = null;
        InputStream binaryStream = null;
        while (rs.next()) {
            System.out.println("###########");
            xmlfile = rs.getBlob(11);
            System.out.println(xmlfile);
            binaryStream = xmlfile.getBinaryStream(1, xmlfile.length());
            //System.out.println(binaryStream + "**********");
            String str = binaryStream.toString();
            bdata = str.getBytes();
            origFile = new String(bdata, "UTF-8");

        }

        Scanner s = new Scanner(binaryStream).useDelimiter("\\A");
        String result = s.hasNext() ? s.next() : "";
        System.out.print("*****" + result);

        JSONObject obj = XML.toJSONObject(result);
        String stringToBeInserted = obj.toString(4);

        try {

            Mongo mongo = new Mongo("localhost", 27017);
            DB db = mongo.getDB("PIE3");

            // get a single collection
            DBCollection collection = db.getCollection("insurersname");

            // convert JSON to DBObject directly
            DBObject dbObject = (DBObject) JSON.parse(stringToBeInserted);

            collection.insert(dbObject);

            System.out.println("Done##############################");



        }
        catch (MongoException e) {
            e.printStackTrace();
        }
        return p;
    }







//
//    @Override
//    public String toString() {
//        return super.toString();
//    }

}
