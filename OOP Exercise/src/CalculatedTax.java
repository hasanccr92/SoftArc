import java.util.List;

public class CalculatedTax {
    private List<String> taxList;

    public CalculatedTax(List<String> taxList) {
        this.taxList = taxList;
    }

    public List<String> getTaxList() {
        return taxList;
    }
}
