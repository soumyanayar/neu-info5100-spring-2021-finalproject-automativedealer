package group4.gui.panel;

import group4.dao.MakeDao;
import group4.dao.ModelDao;
import group4.dao.VehicleDao;
import group4.dao.impl.MakeDaoImpl;
import group4.dao.impl.ModelDaoImpl;
import group4.dao.impl.VehicleDaoImpl;
import group4.entity.Make;
import group4.entity.Model;
import group4.entity.Vehicle;
import group4.gui.frame.MainFrame;
import group4.util.GUIUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

public class AddPanel extends JPanel {
    public static AddPanel instance = new AddPanel();
    private JTextField txtVehicleID;
    private JTextField txtVin;
    private JTextField txtDealerID;
    private JComboBox cmbMake;
    private JComboBox cmbModel;
    private JComboBox cmbYear;
    private JTextField txtCategory;
    private JTextField txtPrice;
    private JTextField txtColor;
    private JTextField txtMiles;
    private JTextField txtRating;
    private JTextField txtImageUrls;
    private JTextField txtEngine;
    private JTextField txtTransmission;
    private JTextField txtStock;
    private JTextField txtSeatCount;
    private JTextField txtFuel;
    private JTextArea txtDescription;

    private VehicleDao vehicleDao;
    private MakeDao makeDao;
    private ModelDao modelDao;
    private TablePanel tablePanel;
    private MainFrame main;

    private int makeID = 1;
    private List<Model>  modelList;

    public AddPanel() {
        setLayout(null);

        JLabel label_1 = new JLabel("Vehicle ID:");
        label_1.setBounds(530, 40, 160, 25);
        add(label_1);

        txtVehicleID = new JTextField();
        txtVehicleID.setBounds(600, 40, 150, 25);
        add(txtVehicleID);
        txtVehicleID.setColumns(10);


        JLabel label_2 = new JLabel("Vin:");
        label_2.setBounds(530, 65, 60, 25);
        add(label_2);

        txtVin = new JTextField();
        txtVin.setBounds(600, 65, 150, 25);
        add(txtVin);
        txtVin.setColumns(10);

        JLabel label_3 = new JLabel("Dealer ID:");
        label_3.setBounds(530, 90, 160, 25);
        add(label_3);

        txtDealerID = new JTextField();
        txtDealerID.setBounds(600, 90, 150, 25);
        add(txtDealerID);
        txtDealerID.setColumns(10);

        JLabel label_4 = new JLabel("Make:");
        label_4.setBounds(530, 115, 60, 25);
        add(label_4);

        makeDao = new MakeDaoImpl();
        List<Make> makeList = makeDao.queryAll();
        cmbMake = new JComboBox(makeList.toArray());
        cmbMake.setBounds(600, 115, 155, 25);
        add(cmbMake);

        cmbMake.addActionListener(new ActionListener(){
            public void  actionPerformed(ActionEvent e){
                Make make = (Make) cmbMake.getSelectedItem();
                makeID = make.getMakeID();
                modelList = modelDao.queryByMakeID(makeID);
                remove(cmbModel);
                cmbModel = new JComboBox(modelList.toArray());
                cmbModel.setBounds(600, 140, 155, 25);
                add(cmbModel);
                revalidate();
            }
        });

        JLabel label_5 = new JLabel("Model:");
        label_5.setBounds(530, 140, 60, 25);
        add(label_5);

        modelDao = new ModelDaoImpl();
        List<Model> modelList = modelDao.queryByMakeID(makeID);
        cmbModel = new JComboBox(modelList.toArray());
        cmbModel.setBounds(600, 140, 155, 25);
        add(cmbModel);

        JLabel label_6 = new JLabel("Year:");
        label_6.setBounds(530, 165, 60, 25);
        add(label_6);

        ArrayList<String> years_tmp = new ArrayList<String>();
        for(int years = 1980; years<= Calendar.getInstance().get(Calendar.YEAR); years++) {
            years_tmp.add(years+"");
        }
        cmbYear = new JComboBox(years_tmp.toArray());
        cmbYear.setBounds(600, 165, 155, 25);
        add(cmbYear);

        JLabel label_7 = new JLabel("Category:");
        label_7.setBounds(530, 190, 60, 25);
        add(label_7);

        txtCategory = new JTextField();
        txtCategory.setBounds(600, 190, 150, 25);
        add(txtCategory);
        txtCategory.setColumns(10);

        JLabel label_8 = new JLabel("Price:");
        label_8.setBounds(530, 215, 60, 25);
        add(label_8);

        txtPrice = new JTextField();
        txtPrice.setBounds(600, 215, 150, 25);
        add(txtPrice);
        txtPrice.setColumns(10);

        JLabel label_9 = new JLabel("Color:");
        label_9.setBounds(530, 240, 60, 25);
        add(label_9);

        txtColor = new JTextField();
        txtColor.setBounds(600, 240, 150, 25);
        add(txtColor);
        txtColor.setColumns(10);

        JLabel label_10 = new JLabel("Miles:");
        label_10.setBounds(800, 65, 80, 25);
        add(label_10);

        txtMiles = new JTextField();
        txtMiles.setBounds(890, 65, 150, 25);
        add(txtMiles);
        txtMiles.setColumns(10);

        JLabel label_11 = new JLabel("Rating:");
        label_11.setBounds(800, 90, 80, 25);
        add(label_11);

        txtRating = new JTextField();
        txtRating.setBounds(890, 90, 150, 25);
        add(txtRating);
        txtRating.setColumns(10);

        JLabel label_12 = new JLabel("Image Urls:");
        label_12.setBounds(800, 115, 80, 25);
        add(label_12);

        txtImageUrls = new JTextField();
        txtImageUrls.setBounds(890, 115, 150, 25);
        add(txtImageUrls);
        txtImageUrls.setColumns(10);

        JLabel label_13 = new JLabel("Engine:");
        label_13.setBounds(800, 140, 80, 25);
        add(label_13);

        txtEngine = new JTextField();
        txtEngine.setBounds(890, 140, 150, 25);
        add(txtEngine);
        txtEngine.setColumns(10);

        JLabel label_14 = new JLabel("Transmission:");
        label_14.setBounds(800, 165, 160, 25);
        add(label_14);

        txtTransmission = new JTextField();
        txtTransmission.setBounds(890, 165, 150, 25);
        add(txtTransmission);
        txtTransmission.setColumns(10);

        JLabel label_15 = new JLabel("Stock:");
        label_15.setBounds(800, 190, 80, 25);
        add(label_15);

        txtStock = new JTextField();
        txtStock.setBounds(890, 190, 150, 25);
        add(txtStock);
        txtStock.setColumns(10);

        JLabel label_16 = new JLabel("Seat Count:");
        label_16.setBounds(800, 215, 80, 25);
        add(label_16);

        txtSeatCount = new JTextField();
        txtSeatCount.setBounds(890, 215, 150, 25);
        add(txtSeatCount);
        txtSeatCount.setColumns(10);

        JLabel label_17 = new JLabel("Fuel:");
        label_17.setBounds(800, 240, 80, 25);
        add(label_17);

        txtFuel = new JTextField();
        txtFuel.setBounds(890, 240, 150, 25);
        add(txtFuel);
        txtFuel.setColumns(10);

        JLabel label_18 = new JLabel("Car Description:");
        label_18.setBounds(530, 290, 160, 25);
        add(label_18);

        txtDescription = new JTextArea(3,10);
        txtDescription.setLineWrap(true);
        txtDescription.setWrapStyleWord(true);
        txtDescription.setBounds(640, 290, 400, 50);
        //add(txtVehicleDesc);
        //txtVehicleDesc.setColumns(10);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(640, 290, 400, 60);
        scrollPane.setViewportView(txtDescription);
        add(scrollPane);

        JButton btnNewButton = new JButton("Add");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                // Right data type?
                int vehicleID=0;
                try{
                    String vehicleIdText = txtVehicleID.getText().trim();
                    if (vehicleIdText.isEmpty()){
                        JOptionPane.showMessageDialog(null, "VehicleId is empty", "Missing Field", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    vehicleID = Integer.parseInt(vehicleIdText);
                    if (vehicleID<0 || vehicleID >= Short.MAX_VALUE){
                        JOptionPane.showMessageDialog(null, "VehicleId not in range", "Wrong Input", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Wrong data type for VehicleId", "Wrong Input", JOptionPane.WARNING_MESSAGE);
                    return;
                };

                String vinText = txtVin.getText().trim();
                if (vinText.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Vin is empty", "Missing Field", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                int vin=0;
                try{
                    vin = Integer.parseInt(vinText);
                    if (vin<0 || vin >= Short.MAX_VALUE){
                        JOptionPane.showMessageDialog(null, "Vin not in range", "Wrong Input", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                }catch (NumberFormatException e){
                    JOptionPane.showMessageDialog(null,"Wrong data type for VIN","Wrong Input",JOptionPane.WARNING_MESSAGE);
                    return;
                };

                String dealerIdText=null;
                int dealerID=0;
                try{
                    dealerIdText = txtDealerID.getText().trim();
                    if (dealerIdText.isEmpty()){
                        JOptionPane.showMessageDialog(null, "DealerId is empty", "Missing Field", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    dealerID = Integer.parseInt(dealerIdText);
                    if (dealerID<0 || dealerID >= Byte.MAX_VALUE){
                        JOptionPane.showMessageDialog(null, "DealerID not in range", "Wrong Input", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                }catch (Exception e){
                    JOptionPane.showMessageDialog(null,"Enter Valid Input","Wrong Input",JOptionPane.WARNING_MESSAGE);
                    return;
                };


                Make make = (Make) cmbMake.getSelectedItem();
                Model model = (Model) cmbModel.getSelectedItem();
                int year = Integer.parseInt(Objects.requireNonNull(cmbYear.getSelectedItem()).toString());

                String category = null;
                try{
                    category = txtCategory.getText().trim();
                    if (category.isEmpty()){
                        JOptionPane.showMessageDialog(null, "Category is empty", "Missing Field", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    if (category.length()>=50){
                        JOptionPane.showMessageDialog(null, "Category is too long", "Wrong Input", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                }catch (Exception e){
                    JOptionPane.showMessageDialog(null,"Enter Valid Input for Category ","Wrong Field",JOptionPane.WARNING_MESSAGE);
                    return;
                }


                String priceText;
                double price=0;
                try{
                    priceText = txtPrice.getText().trim();
                    if (priceText.isEmpty()){
                        JOptionPane.showMessageDialog(null, "Price is empty", "Missing Field", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    price = Double.parseDouble(priceText);
                    if (price<0 || price >= Float.MAX_VALUE){
                        JOptionPane.showMessageDialog(null, "Price not in range", "Wrong Input", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                }catch (Exception e){
                    JOptionPane.showMessageDialog(null,"Enter Valid Input for Price","Wrong Input",JOptionPane.WARNING_MESSAGE);
                    return;
                }

                String color=null;
                try{
                    color = txtColor.getText().trim();
                    if (color.isEmpty()){
                        JOptionPane.showMessageDialog(null, "Color is empty", "Missing Field", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    if (color.length() >= 50){
                        JOptionPane.showMessageDialog(null, "Color is too long", "Wrong Input", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                }catch (Exception e){
                    JOptionPane.showMessageDialog(null,"Enter Valid Input for Color","Wrong Input",JOptionPane.WARNING_MESSAGE);
                    return;
                }

                String milesText=null;
                int miles=0;
                try{
                    milesText = txtMiles.getText().trim();
                    if (milesText.isEmpty()){
                        JOptionPane.showMessageDialog(null, "Miles is empty", "Missing Field", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    miles = Integer.parseInt(milesText);
                    if (miles < 0){
                        JOptionPane.showMessageDialog(null, "Miles not in range", "Wrong Input", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                }catch (Exception e){
                    JOptionPane.showMessageDialog(null,"Enter Valid Input for Miles","Wrong Input",JOptionPane.WARNING_MESSAGE);
                    return;
                }


                String ratingText;
                int rating=0;
                try{
                    ratingText = txtRating.getText().trim();
                    if (ratingText.isEmpty()){
                        JOptionPane.showMessageDialog(null, "Rating is empty", "Missing Field", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    rating = Integer.parseInt(ratingText);
                    if (rating<0 || rating >= Byte.MAX_VALUE){
                        JOptionPane.showMessageDialog(null, "Rating not in range", "Wrong Input", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                }catch (Exception e){
                    JOptionPane.showMessageDialog(null,"Enter Valid Input for Rating","Wrong Input",JOptionPane.WARNING_MESSAGE);
                    return;
                }


                String imageUrls = null;
                try{
                    imageUrls = txtImageUrls.getText().trim();
                    if (imageUrls.isEmpty()){
                        JOptionPane.showMessageDialog(null, "Image Urls is empty", "Missing Field", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    if (imageUrls.length() >= 2000){
                        JOptionPane.showMessageDialog(null, "image Urls is too long", "Wrong Input", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                }catch (Exception e){
                    JOptionPane.showMessageDialog(null,"Enter Valid Input for Image","Wrong Input",JOptionPane.WARNING_MESSAGE);
                    return;
                }


                String engine = null;
                try{
                    engine = txtEngine.getText().trim();
                    if (engine.isEmpty()){
                        JOptionPane.showMessageDialog(null, "Engine is empty", "Missing Field", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    if (engine.length()>=200){
                        JOptionPane.showMessageDialog(null, "Engine is too long", "Wrong Input", JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                }catch (Exception e){
                    JOptionPane.showMessageDialog(null,"Enter Valid Input for Engine","Wrong Input",JOptionPane.WARNING_MESSAGE);
                    return;
                }

                String transmission = null;
                try{
                    transmission = txtTransmission.getText().trim();
                    if (transmission.isEmpty()){
                        JOptionPane.showMessageDialog(null, "Transmission is empty", "Missing Field", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    if (transmission.length()>=200){
                        JOptionPane.showMessageDialog(null, "Transmission is too long", "Wrong Input", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                }catch (Exception e){
                    JOptionPane.showMessageDialog(null,"Enter Valid Input for Transmission","Wrong Input",JOptionPane.WARNING_MESSAGE);
                    return;
                }

                String stockText=null;
                int stock=0;
                try{
                    stockText = txtStock.getText().trim();
                    if (stockText.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Stock is empty", "Missing Field", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    stock = Integer.parseInt(stockText);
                    if (stock < 0){
                        JOptionPane.showMessageDialog(null, "Stock not in range", "Wrong Input", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                }catch (Exception e){
                    JOptionPane.showMessageDialog(null,"Enter Valid Input for Stock","Wrong Input",JOptionPane.WARNING_MESSAGE);
                    return;
                }

                String seatCountText;
                int seatCount = 0;
                try{
                    seatCountText = txtSeatCount.getText().trim();
                    if (seatCountText.isEmpty()){
                        JOptionPane.showMessageDialog(null, "Seat Count is empty", "Missing Field", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    seatCount = Integer.parseInt(seatCountText);
                    if (seatCount<0){
                        JOptionPane.showMessageDialog(null, "Seat Count not in range", "Wrong Input", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                }catch (Exception e){
                    JOptionPane.showMessageDialog(null,"Enter Valid Input for Seat Count","Wrong Input",JOptionPane.WARNING_MESSAGE);
                    return;
                }

                String fuel = null;
                try{
                    fuel = txtFuel.getText().trim();
                    if (fuel.isEmpty()){
                        JOptionPane.showMessageDialog(null, "Fuel is empty", "Missing Field", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    if (fuel.length()>=200){
                        JOptionPane.showMessageDialog(null, "Fuel is too long", "Wrong Input", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                }catch (Exception e){
                    JOptionPane.showMessageDialog(null,"Enter Valid Input for Fuel Count","Wrong Input",JOptionPane.WARNING_MESSAGE);
                    return;
                }

                String description = null;
                try{
                    description = txtDescription.getText().trim();
                    if (description.isEmpty()){
                        JOptionPane.showMessageDialog(null, "Description is empty", "Missing Field", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    if (description.length()>=4000){
                        JOptionPane.showMessageDialog(null, "Description is too long", "Wrong Input", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null,"Enter Valid Input for Description","Wrong Input",JOptionPane.WARNING_MESSAGE);
                    return;
                }


                Vehicle vehicle=new Vehicle();
                vehicle.setVehicleID(vehicleID);
                vehicle.setVin(vin);
                vehicle.setDealerID(dealerID);
                vehicle.setMakeID(Objects.requireNonNull(make).getMakeID());
                vehicle.setModelID(Objects.requireNonNull(model).getModelID());
                vehicle.setYear(year);
                vehicle.setCategory(category);
                vehicle.setPrice(price);
                vehicle.setColor(color);
                vehicle.setMiles(miles);
                vehicle.setRating(rating);
                vehicle.setImageUrls(imageUrls);
                vehicle.setEngine(engine);
                vehicle.setTransmission(transmission);
                vehicle.setStock(stock);
                vehicle.setSeatCount(seatCount);
                vehicle.setFuel(fuel);
                vehicle.setDescription(description);

                vehicleDao = new VehicleDaoImpl();

                if(vehicleDao.add(vehicle)){
                    JOptionPane.showMessageDialog(null, "Successfully added");
                    txtVehicleID.setText("");
                    txtVin.setText("");
                    txtDealerID.setText("");
                    cmbMake.setSelectedIndex(0);
                    cmbModel.setSelectedIndex(0);
                    cmbYear.setSelectedIndex(0);
                    txtCategory.setText("");
                    txtPrice.setText("");
                    txtColor.setText("");
                    txtMiles.setText("");
                    txtRating.setText("");
                    txtImageUrls.setText("");
                    txtEngine.setText("");
                    txtTransmission.setText("");
                    txtStock.setText("");
                    txtSeatCount.setText("");
                    txtFuel.setText("");
                    txtDescription.setText("");

                }else{
                    JOptionPane.showMessageDialog(null, "Fail to add");
                }

            }
        });
        btnNewButton.setBounds(950, 360, 116, 25);
        add(btnNewButton);

    }

    public static void main(String[] args) {
        GUIUtil.showPanel(AddPanel.instance,1);
    }
}