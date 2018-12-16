package chart_project.chart_panel;

import chart_project.InitScene;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;

@SuppressWarnings("serial")
public class PanelLineChart extends JFXPanel implements InitScene{

	private LineChart<String, Number> lineChart;
	
	@Override
	public Scene createScene() {
		Group root = new Group();
		Scene scene = new Scene(root);
		root.setAutoSizeChildren(true);
		
		CategoryAxis xAxis = new CategoryAxis();
		xAxis.setLabel("과목");

		NumberAxis yAxis = new NumberAxis();
		yAxis.setLabel("점수");
		
		lineChart = new LineChart<>(xAxis, yAxis);
		lineChart.setPrefSize(500, 250);
		lineChart.setData(getChartData());
		lineChart.setTitle("Line Chart");
		lineChart.setLegendVisible(true);	// 범례 표시 유무
		lineChart.setLegendSide(Side.BOTTOM);// 범례 위치

		root.getChildren().add(lineChart);

		return scene;
	}
	
	private static ObservableList<XYChart.Series<String, Number>> getChartData() {
		ObservableList<XYChart.Series<String, Number>> list = FXCollections.observableArrayList();
		
		XYChart.Series<String, Number> dataSeries = new Series<String, Number>();
		dataSeries.setName("현빈");
		dataSeries.getData().add(new XYChart.Data<>("사전", 90));
		dataSeries.getData().add(new XYChart.Data<>("중간", 80));
		dataSeries.getData().add(new XYChart.Data<>("기발", 80));
		
		XYChart.Series<String, Number> dataSeries2 = new Series<String, Number>();
		dataSeries2.setName("박신혜");
		dataSeries2.getData().add(new XYChart.Data<>("사전", 50));
		dataSeries2.getData().add(new XYChart.Data<>("중간", 60));
		dataSeries2.getData().add(new XYChart.Data<>("기발", 95));
		
		list.add(dataSeries);
		list.add(dataSeries2);
		
		return list;
	}

}
