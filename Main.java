package Java_01pj;

import java.util.ArrayList;
import java.util.Scanner;

// 메뉴 클래스
class Menu {
    protected String name;
    protected String description;

    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
    }
}

// 상품 클래스
class Product extends Menu {
    protected double price;

    public Product(String name, String description, double price) {
        super(name, description);
        this.price = price;
    }
}

// 주문 클래스
class Order {
    private ArrayList<Product> cart = new ArrayList<>();

    public void addToCart(Product product) {
        cart.add(product);
        System.out.println(product.name + "이(가) 장바구니에 추가되었습니다.");
    }

    public void viewCart() {
        System.out.println("[ 장바구니 목록 ]");
        for (Product product : cart) {
            System.out.println(product.name + " - " + product.price + "원");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Order order = new Order();

        System.out.println("SHAKESHACK BURGER에 오신걸 환영합니다.");
        System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.");

        // 메뉴 및 상품 초기화
        Product burger = new Product("Burgers", "앵거스 비프 통살을 다져만든 버거", 10000.0);
        Product frozenCustard = new Product("Forzen Custard", "매장에서 신선하게 만드는 아이스크림", 5000.0);
        Product drinks = new Product("Drinks", "매장에서 직접 만드는 음료", 3000.0);
        Product beer = new Product("Beer", "뉴욕 브루클린 브루어리에서 양조한 맥주", 7000.0);

        // 메뉴 출력
        System.out.println("\n[ SHAKESHACK MENU ]");
        System.out.println("1. " + burger.name + "\t\t| " + burger.description);
        System.out.println("2. " + frozenCustard.name + "\t| " + frozenCustard.description);
        System.out.println("3. " + drinks.name + "\t\t| " + drinks.description);
        System.out.println("4. " + beer.name + "\t\t| " + beer.description);

        System.out.println("\n[ ORDER MENU ]");
        System.out.println("5. Order\t| 장바구니를 확인 후 주문합니다.");
        System.out.println("6. Cancel\t| 진행중인 주문을 취소합니다.");

        // 사용자 입력 받기
        System.out.print("\n메뉴를 선택해주세요: ");
        int choice = scanner.nextInt();

        // 선택된 메뉴에 따라 처리
        switch (choice) {
            case 1:
                order.addToCart(burger);
                break;
            case 2:
                order.addToCart(frozenCustard);
                break;
            case 3:
                order.addToCart(drinks);
                break;
            case 4:
                order.addToCart(beer);
                break;
            case 5:
                order.viewCart();
                // 주문 로직 추가
                break;
            case 6:
                // 주문 취소 로직 추가
                System.out.println("주문이 취소되었습니다.");
                break;
            default:
                System.out.println("잘못된 선택입니다.");
        }
    }
}
