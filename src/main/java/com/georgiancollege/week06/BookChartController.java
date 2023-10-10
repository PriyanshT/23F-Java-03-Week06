package com.georgiancollege.week06;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BookChartController implements Initializable {

    @FXML
    private BarChart<String, Integer> barChart;

    @FXML
    private CategoryAxis categoryAxis;

    @FXML
    private NumberAxis numberAxis;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        categoryAxis.setLabel("Book Name");
        numberAxis.setLabel("Units Sold");

        barChart.getData().addAll(DBUtility.getChartDataFromDB());

        XYChart.Series<String, Integer> newData = new XYChart.Series<>();
        newData.setName("2022");

        newData.getData().add(new XYChart.Data<>("A Clash of Kings", 20));
        newData.getData().add(new XYChart.Data<>("FakeBook2", 40));
        newData.getData().add(new XYChart.Data<>("FakeBook3", 60));

        barChart.getData().addAll(newData);
    }

    @FXML
    void viewTable_onClick(ActionEvent event) throws IOException {
        SceneChanger.changeScene(event, "book-table-view.fxml", "Book Table");
    }
}
