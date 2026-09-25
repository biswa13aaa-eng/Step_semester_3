package encapsulation.assigment_problems;

public class Cart {
    private final String cartId;
    private final int[] itemPrices;
    private int count;

    public Cart(String cartId, int maxItems) {
        this.cartId = cartId;
        this.itemPrices = new int[maxItems];
        this.count = 0;
    }

    public void addItem(int price) {
        if (count < itemPrices.length) {
            itemPrices[count++] = price;
        }
    }

    public int getTotal() {
        int total = 0;
        for (int i = 0; i < count; i++) {
            total += itemPrices[i];
        }
        return total;
    }

    public int getItemCount() {
        return count;
    }

    public String getCartId() {
        return cartId;
    }

    public static void main(String[] args) {
        Cart cart = new Cart("CART-5", 20);
        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        System.out.println("cart.getTotal() -> " + cart.getTotal());
        System.out.println("cart.getItemCount() -> " + cart.getItemCount());
    }
}