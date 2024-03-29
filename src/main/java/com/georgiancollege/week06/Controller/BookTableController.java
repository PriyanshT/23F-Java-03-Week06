package com.georgiancollege.week06.Controller;

import com.georgiancollege.week06.Utilities.DBUtility;
import com.georgiancollege.week06.Model.Book;
import com.georgiancollege.week06.Utilities.SceneChanger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BookTableController implements Initializable {
    @FXML
    private TableView<Book> tableView;

    @FXML
    private TableColumn<Book, String> authorColumn;

    @FXML
    private TableColumn<Book, Boolean> availabilityColumn;

    @FXML
    private TableColumn<Book, Integer> bookIdColumn;

    @FXML
    private TableColumn<Book, String> bookNameColumn;

    @FXML
    private TableColumn<Book, String> genreColumn;

    @FXML
    private TableColumn<Book, Double> priceColumn;

    @FXML
    private TableColumn<Book, Integer> unitsSoldColumn;

    @FXML
    private CheckBox availableCheckBox;

    @FXML
    private CheckBox expensiveCheckBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<Book> books = DBUtility.getBooksFromDB("1");
        // System.out.println(books);

        bookIdColumn.setCellValueFactory(new PropertyValueFactory<>("bookId"));
        bookNameColumn.setCellValueFactory(new PropertyValueFactory<>("bookName"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
        genreColumn.setCellValueFactory(new PropertyValueFactory<>("genre"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        availabilityColumn.setCellValueFactory(new PropertyValueFactory<>("available"));
        unitsSoldColumn.setCellValueFactory(new PropertyValueFactory<>("unitsSold"));

        tableView.getItems().addAll(books);
    }

    @FXML
    void manipulateTable(ActionEvent event) {
        tableView.getItems().clear();
        if(expensiveCheckBox.isSelected() && availableCheckBox.isSelected()){
            tableView.getItems().addAll(DBUtility.getBooksFromDB("price > 20 AND is_available = true"));
        } else if(expensiveCheckBox.isSelected() && !availableCheckBox.isSelected()){
            tableView.getItems().addAll(DBUtility.getBooksFromDB("price > 20"));
        } else if(!expensiveCheckBox.isSelected() && availableCheckBox.isSelected()){
            tableView.getItems().addAll(DBUtility.getBooksFromDB("is_available = true"));
        } else {
            tableView.getItems().addAll(DBUtility.getBooksFromDB("1"));
        }
    }


    @FXML
    void addNewBook_onClick(ActionEvent event) throws IOException {
        SceneChanger.changeScene(event, "create-book-view.fxml", "Create Book!");
    }

    @FXML
    void viewChart_onClick(ActionEvent event) throws IOException {
        SceneChanger.changeScene(event, "book-chart-view.fxml", "Chart View!");
    }
}
