/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class jAVA extends Application {
  private Button btView = new Button("View");
  private Button btInsert = new Button("Insert");
  private Button btUpdate = new Button("Update");
  private Button btClear = new Button("Clear");
  private TextField tfid = new TextField();
  private TextField tflastname = new TextField();
  private TextField tffirstname = new TextField();
  private TextField tfMi = new TextField();
  private TextField tfaddress = new TextField();
  private TextField tfcity = new TextField();
  private TextField tfstate = new TextField();
  private TextField tftelephone = new TextField();
  private Label lblStatus = new Label();
  
  // The Statement for processing queries
 

  private Statement stmt;
  
  static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

   static final String DB_URL = "jdbc:mysql://localhost:3306/sakila";



   //  Database credentials

   static final String USER = "root";

   static final String PASS = "MySQL55!";

  
  
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    
      
  
  try {
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver loaded");
      // Connect to the local InterBase database
     
      Connection conn = DriverManager.getConnection
//        ("dbc:odbc:exampleMDBDataSource", "", "" );
        ("jdbc:mysql://localhost:3306/sakila", "root","MySQL55!");
      System.out.println("Database connected\n");

      lblStatus.setText("Database connected");

      // Create a statement
      stmt = conn.createStatement();
  }
  catch (Exception ex) {
      lblStatus.setText("Connection failed: " + ex);
    }
      
      VBox vBox = new VBox(5);
    
    HBox hBox1 = new HBox(5);
    hBox1.getChildren().addAll(new Label("id"), tfid);
    HBox hBox2 = new HBox(5);
    hBox2.getChildren().addAll(new Label("lastname"), tflastname, new Label("firstname"), tffirstname, new Label("Mi"), tfMi);
    tflastname.setPrefColumnCount(8);
    tffirstname.setPrefColumnCount(8);
    tfMi.setPrefColumnCount(1);

    HBox hBox3 = new HBox(5);
    hBox3.getChildren().addAll(new Label("address"), tfaddress);
    HBox hBox4 = new HBox(5);
    hBox4.getChildren().addAll(new Label("city"), tfcity, new Label("state"), tfstate);   
    HBox hBox5 = new HBox(5);
    hBox5.getChildren().addAll(new Label("telephone"), tftelephone);
 
    vBox.getChildren().addAll(hBox1, hBox2, hBox3, hBox4, hBox5);
    
    HBox hBox = new HBox(5);
    hBox.getChildren().addAll(btView, btInsert, btUpdate, btClear);
    hBox.setAlignment(Pos.CENTER);
    
    BorderPane pane = new BorderPane();
    pane.setCenter(vBox);
    pane.setTop(lblStatus);
    pane.setBottom(hBox);
    
    // Create a scene and place it in the stage
    Scene scene = new Scene(pane, 400, 200);
    primaryStage.setTitle("Exercise"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage

    initializeDB();
    
    btView.setOnAction(e -> view());
    btInsert.setOnAction(e -> insert());
    btUpdate.setOnAction(e -> update());
    btClear.setOnAction(e -> clear());    
  }
   
  private void initializeDB() {
    
  }
    
    /**View record by ID*/
  private void view() {
    // Build a SQL SELECT statement
    String query = "SELECT * FROM exercise WHERE id = "
      + "'" + tfid.getText().trim() + "'";

    try {
      // Execute query
      ResultSet rs = stmt.executeQuery(query);
      loadToTextField(rs);
    }
    catch(SQLException ex) {
      lblStatus.setText("Select failed: " + ex);
    }
  }

  /**Load the record into text fields*/
  private void loadToTextField(ResultSet rs) throws SQLException {
    if (rs.next()) {
      tflastname.setText(rs.getString(2));
      tffirstname.setText(rs.getString(3));
      tfMi.setText(rs.getString(4));
      tfaddress.setText(rs.getString(5));
      tfcity.setText(rs.getString(6));
      tfstate.setText(rs.getString(7));
      tftelephone.setText(rs.getString(8));
      lblStatus.setText("Record found");
    }
    else
      lblStatus.setText("Record not found");
  }

  /**Insert a new record*/
  private void insert() {
    // Build a SQL INSERT statement
    String insertStmt =
      "INSERT INTO exercise(id, lastname, firstname, Mi, address, city" +
      " , state, telephone) VALUES('" +
      tfid.getText().trim() + "','" +
      tflastname.getText().trim() + "','" +
      tffirstname.getText().trim() + "','" +
      tfMi.getText().trim() + "','" +
      tfaddress.getText().trim() + "','" +
      tfcity.getText().trim() + "','" +
      tfstate.getText().trim() + "','" +
      tftelephone.getText().trim() + "');";

    try {
      stmt.executeUpdate(insertStmt);
      lblStatus.setText("record inserted");
    }
    catch (SQLException ex) {
      lblStatus.setText("Insertion failed: " + ex);
    }

    
  }

  /**Update a record*/
  private void update() {
    // Build a SQL UPDATE statement
    String updateStmt = "UPDATE exercise " +
      "SET LastName = '" + tflastname.getText().trim() + "'," +
      "FirstName = '" + tffirstname.getText().trim() + "'," +
      "mi = '" + tfMi.getText().trim() + "'," +
      "Address = '" + tfaddress.getText().trim() + "'," +
      "City = '" + tfcity.getText().trim() + "'," +
      "State = '" + tfstate.getText().trim() + "'," +
      "Telephone = '" + tftelephone.getText().trim() + "' " +
      "WHERE ID = '" + tfid.getText().trim() + "'";

    try {
      stmt.executeUpdate(updateStmt);
      lblStatus.setText("Record updated");
    }
    catch(SQLException ex) {
      lblStatus.setText("Update failed: " + ex);
    }
  }

  /**Clear text fields*/
  private void clear() {
    tfid.setText(null);
    tflastname.setText(null);
    tffirstname.setText(null);
    tfMi.setText(null);
    tfaddress.setText(null);
    tfcity.setText(null);
    tfstate.setText(null);
    tftelephone.setText(null);
  }


  /**
   * The main method is only needed for the IDE with limited
   * avaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}