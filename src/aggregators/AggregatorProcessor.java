package aggregators;

import java.io.IOException;
import java.util.List;

import fileprocessors.StockFileReader;

public class AggregatorProcessor <T extends Aggregator>{
	T aggregator;
    String file;
    public AggregatorProcessor(T aggregator, String file) {
        this.aggregator = aggregator;
        this.file = file;
    }
public double runAggregator(int colIdx) throws IOException{
     StockFileReader fileReader = new StockFileReader(file);
     List<String> lines = fileReader.readFileData();
     colIdx--;
     for(String line : lines){
        String [] numbers = line.split(",");
        Number value = Double.parseDouble(numbers[colIdx]);
        aggregator.add(value.doubleValue());
     }
     double number = aggregator.calculate();
     return number;
}
	
}
