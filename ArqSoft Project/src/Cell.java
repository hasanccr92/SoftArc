// Class to represent a single cell in the spreadsheet
public class Cell {
    private String content; // Stores the raw content of the cell

    // Constructor
    public Cell(String content) {
        this.content = content;
    }

    // Getter for content
    public String getContent() {
        return content;
    }

    // Setter for content
    public void setContent(String content) {
        this.content = content;
    }

    // Get the value of the cell as a number, if applicable
    public double getAsNumber() throws IllegalArgumentException {
        if (content == null || content.isEmpty()) {
            return 0.0; // Empty content is treated as 0
        }
        try {
            return Double.parseDouble(content); // Try to parse as a number
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Content is not a valid number: " + content);
        }
    }

    // Get the value of the cell as a string
    public String getAsString() {
        return content == null ? "" : content;
    }
}
