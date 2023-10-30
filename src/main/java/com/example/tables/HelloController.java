package com.example.tables;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class HelloController {

    @FXML
    private Button btnLoad;

    @FXML
    private TableView<Car> table;

    @FXML
    private TextField txtFname;

    @FXML
    ListView<Car> carList;

    ObservableList<Car> cars = FXCollections.observableArrayList();

    public void initialize(){
        cars.add(new Car("Тойота", "зеленый", 210));

        carList.setItems(cars);

        initTable();
    }

    private void initTable() {
        table.setItems(cars);
        table.getColumns().clear();
        table.setEditable(true);

        TableColumn<Car, String> columnMod = new TableColumn<>("Модель");
        columnMod.setCellValueFactory(new PropertyValueFactory<>("model")); //как извлекать данные из объекта
        //как нарисовать в каждой ячейке столбца поле для ввода
        columnMod.setCellFactory(TextFieldTableCell.forTableColumn());

        TableColumn<Car, String> columnColor = new TableColumn<>("Цвет");
        columnColor.setCellValueFactory(new PropertyValueFactory<>("color"));

        TableColumn<Car, Integer> columnSpeed = new TableColumn<>("Скорость");
        columnSpeed.setCellValueFactory(new PropertyValueFactory<>("speed"));
        columnSpeed.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()) );

        table.getColumns().addAll(columnMod, columnColor, columnSpeed);
    }

    @FXML
    private void loadCarsFromFile(){
        String fname = txtFname.getText();
        try{
            List<String> lines = Files.readAllLines(Path.of(fname));
            for (String s: lines ) {
                String[] words = s.split(" ");
                Car car = new Car(words[0], words[1], Integer.parseInt(words[2]));
                cars.add(car);
            }

        }catch (IOException e)
        {}
    }

}
