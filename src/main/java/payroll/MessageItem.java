package payroll;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MessageItem {
    private String exception;
    private String message;
}
