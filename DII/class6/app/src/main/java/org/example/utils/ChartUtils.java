package org.example.utils;

import org.knowm.xchart.*;
import org.knowm.xchart.style.Styler;
import org.knowm.xchart.style.markers.SeriesMarkers;
import org.knowm.xchart.BitmapEncoder;

import java.awt.BasicStroke;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class ChartUtils {

    private static final String GRAPH_DIR = "src/main/resources/graphs/";

    public static void createAndSavePerformanceChart(String title,
                                                     List<Double> nValues,
                                                     Map<String, List<Double>> measuredSeries, // Series name -> Y-values
                                                     Map<String, List<Double>> theoreticalSeries) { // Series name -> Y-values
        try {
            Files.createDirectories(Paths.get(GRAPH_DIR));
        } catch (IOException e) {
            System.err.println("Error creating graph directory: " + e.getMessage());
            return;
        }

        XYChart chart = new XYChartBuilder()
                .width(1000)
                .height(700)
                .title(title)
                .xAxisTitle("Input Size (n)")
                .yAxisTitle("Value") // Generic Y-axis title
                .build();

        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNW);
        chart.getStyler().setDefaultSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Line);
        // chart.getStyler().setYAxisLogarithmic(true); // Uncomment if Y values have huge differences

        // Add measured series
        if (measuredSeries != null) {
            for (Map.Entry<String, List<Double>> entry : measuredSeries.entrySet()) {
                if (nValues.size() == entry.getValue().size()) {
                    XYSeries series = chart.addSeries(entry.getKey() + " (Measured Time - ns)", nValues, entry.getValue());
                    series.setMarker(SeriesMarkers.CIRCLE); // Markers for measured data
                } else {
                     System.err.println("Data size mismatch for measured series: " + entry.getKey());
                }
            }
        }

        // Add theoretical series
        // These will be plotted on the same Y-axis. If scales are too different,
        // consider separate charts, secondary Y-axis (more complex with XChart), or log scale.
        if (theoreticalSeries != null) {
            for (Map.Entry<String, List<Double>> entry : theoreticalSeries.entrySet()) {
                 if (nValues.size() == entry.getValue().size()) {
                    XYSeries series = chart.addSeries(entry.getKey() + " (Theoretical)", nValues, entry.getValue());
                    series.setMarker(SeriesMarkers.NONE); // No markers for theoretical lines
                    series.setLineStyle(new BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 10.0f, new float[]{5.0f}, 0.0f)); // Dashed line
                 } else {
                     System.err.println("Data size mismatch for theoretical series: " + entry.getKey());
                 }
            }
        }


        try {
            String filename = GRAPH_DIR + title.replaceAll("[^a-zA-Z0-9.-]", "_") + ".png";
            BitmapEncoder.saveBitmap(chart, filename, BitmapEncoder.BitmapFormat.PNG);
            System.out.println("Saved chart: " + filename);
        } catch (IOException e) {
            System.err.println("Error saving chart: " + e.getMessage());
        }
    }
}