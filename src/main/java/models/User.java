package models;

import exceptions.PaymentInvalidException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable {
    private String name;
    private String email;
    private String password;
    private double pendingValueTickets;

    private List<Ticket> tickets = new ArrayList<>();

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public void bookTickets(List<Ticket> tickets){
        setTickets(tickets);
        setPendingValueTickets(calculateValueTickets());
    }

    public String viewHistory(){
        StringBuilder history = new StringBuilder();
        if (tickets.isEmpty()){
            history.append("Nenhum ticket encontrado. \n");
        }
        else {
            for (Ticket ticket : tickets) {
                history.append(ticket.toString()).append("\n");
            }
        }

        return history.toString();
    }

    public void cancelTicket(Ticket ticket){
        tickets.remove(ticket);
        pendingValueTickets = pendingValueTickets - ticket.getValue();
    }

    public void cancelAllTickets(){
        tickets.clear();
        pendingValueTickets = 0;
    }

    public boolean makePayment(double paymentValue){
        if (paymentValue == pendingValueTickets){
            pendingValueTickets = 0;
            tickets.stream().forEach(ticket -> ticket.setPayment(new Payment("Pix")));
        }

        throw new PaymentInvalidException("Valor do pagamento incorreto. Valor pendente: R$ " + pendingValueTickets);
    }

    public double calculateValueTickets(){
        return tickets.stream().mapToDouble(Ticket::getValue).sum();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getTotalValueTickets() {
        return pendingValueTickets;
    }

    public void setPendingValueTickets(double valueTickets) {
        pendingValueTickets = valueTickets;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
