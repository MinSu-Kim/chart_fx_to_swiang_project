package chart_project.chart_panel;

import java.util.Iterator;

import chart_project.InitScene;
import chart_project.dto.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.paint.Color;

@SuppressWarnings("serial")
public class PanelBarChart extends JFXPanel implements InitScene{

	private BarChart<String, Number> barChart;
	
	@Override
	public Scene createScene() {
		Group root = new Group();
		Scene scene = new Scene(root, Color.ALICEBLUE);
		root.setAutoSizeChildren(true);
		
		//막 대형 차트의 X 축과 Y 축을 정의하고 레이블을 설정
		CategoryAxis xAxis = new CategoryAxis();
		xAxis.setLabel("과목");

		NumberAxis yAxis = new NumberAxis();
		yAxis.setLabel("점수");

		barChart = new BarChart<>(xAxis, yAxis);
		barChart.setTitle("Bar Chart");
		
		barChart.setPrefSize(500, 250);
		barChart.setData(getChartData());
		
		root.getChildren().add(barChart);

		return scene;
	}
	
	public void deleteAllData() {
		barChart.getData().clear();
	}
	
	public void delChartData(Student std) {
		ObservableList<Series<String, Number>> list = barChart.getData();
		Iterator<Series<String, Number>>  it = list.iterator();
		while(it.hasNext()) {
			Series<String, Number> s = it.next();
			if (s.getName().equals(std.getStdName())) {
				barChart.getData().remove(s);
				break;
			}
		}
	}
	
	public void updateChartData(Student std) {
		ObservableList<Series<String, Number>> list = barChart.getData();
		
		for(int i = 0; i<list.size(); i++) {
			Series<String, Number> s = list.get(i);
			if (s.getName().equals(std.getStdName())) {
				s.getData().set(0, new XYChart.Data<>("국어", std.getKorScore()));
				s.getData().set(1, new XYChart.Data<>("영어", std.getEngScore()));
				s.getData().set(2, new XYChart.Data<>("수학", std.getMathScore()));	
				barChart.getData().set(i, s);
				break;
			}
		}
	}
	
	public void addChartData(Student std) {
		XYChart.Series<String, Number> addSeries = new Series<String, Number>();
		addSeries.setName(std.getStdName());
		addSeries.getData().add(new XYChart.Data<>("국어", std.getKorScore()));
		addSeries.getData().add(new XYChart.Data<>("영어", std.getEngScore()));
		addSeries.getData().add(new XYChart.Data<>("수학", std.getMathScore()));
		System.out.println(addSeries);
		barChart.getData().add(addSeries);
	}
	
	public void addAllChartData() {
		barChart.setData(getChartData());
	}
	
	public XYChart.Series<String, Number> getChartData(Student std) {
		XYChart.Series<String, Number> dataSeries = new Series<String, Number>();
		dataSeries.setName(std.getStdName());
		dataSeries.getData().add(new XYChart.Data<>("국어", std.getKorScore()));
		dataSeries.getData().add(new XYChart.Data<>("영어", std.getEngScore()));
		dataSeries.getData().add(new XYChart.Data<>("수학", std.getMathScore()));
		return dataSeries;
	}
	
	private ObservableList<XYChart.Series<String, Number>> getChartData() {
		ObservableList<XYChart.Series<String, Number>> list = FXCollections.observableArrayList();
		Student std = new Student("S001", "현빈", 90, 60,70);
		XYChart.Series<String, Number> dataSeries = new Series<String, Number>();
		dataSeries.setName(std.getStdName());
		dataSeries.getData().add(new XYChart.Data<>("국어", std.getKorScore()));
		dataSeries.getData().add(new XYChart.Data<>("영어", std.getEngScore()));
		dataSeries.getData().add(new XYChart.Data<>("수학", std.getMathScore()));
		list.add(dataSeries);
		
		Student std2 = new Student("S002", "박신혜", 60, 55,88);
		XYChart.Series<String, Number> dataSeries2 = new Series<String, Number>();
		dataSeries2.setName(std2.getStdName());
		dataSeries2.getData().add(new XYChart.Data<>("국어", std2.getKorScore()));
		dataSeries2.getData().add(new XYChart.Data<>("영어", std2.getEngScore()));
		dataSeries2.getData().add(new XYChart.Data<>("수학", std2.getMathScore()));
		
		list.add(dataSeries2);
		
		return list;
	}

	public BarChart<String, Number> getBarChart() {
		return barChart;
	}

	
}
