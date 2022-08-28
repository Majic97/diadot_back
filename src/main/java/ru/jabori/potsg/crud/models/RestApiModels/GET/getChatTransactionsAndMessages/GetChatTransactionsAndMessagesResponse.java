package ru.jabori.potsg.crud.models.RestApiModels.GET.getChatTransactionsAndMessages;

import ru.jabori.potsg.crud.models.RestApiModels.MessageData;
import ru.jabori.potsg.crud.models.RestApiModels.TransactionData;

import java.io.Serializable;
import java.util.List;

public class GetChatTransactionsAndMessagesResponse implements Serializable {

    private List<TransactionData> transactions;

    private List<MessageData> messages;

    public GetChatTransactionsAndMessagesResponse(List<TransactionData> transactions, List<MessageData> messages) {
        this.transactions = transactions;
        this.messages = messages;
    }

    public List<TransactionData> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<TransactionData> transactions) {
        this.transactions = transactions;
    }

    public List<MessageData> getMessages() {
        return messages;
    }

    public void setMessages(List<MessageData> messages) {
        this.messages = messages;
    }
}
