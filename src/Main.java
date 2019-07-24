//import java.awt.*;
//







//                                      --------BUILDER--------
//
//public class Main {
//    public static void main(String[] args) {
//        Car car = new Car.Builder("Toyota").setName("Lada").setWidth(30).setHeight(50).setMaxSpeed(250).setWheels(5).build();
//    }
//}
//
//class Car {
//    private String name;
//    private int maxSpeed;
//    private int height;
//    private int width;
//    private int wheels;
//
//    public String getName() {
//        return name;
//    }
//    public int getMaxSpeed() {
//        return maxSpeed;
//    }
//    public int getHeight() {
//        return height;
//    }
//    public int getWidth() {
//        return width;
//    }
//    public int getWheels() {
//        return wheels;
//    }
//
//    private Car(Builder builder) {
//        this.name = builder.name;
//        this.maxSpeed = builder.maxSpeed;
//        this.height = builder.height;
//        this.width = builder.width;
//        this.wheels = builder.wheels;
//    }
//
//    static class Builder {
//        String name;
//        int maxSpeed;
//        int height;
//        int width;
//        int wheels;
//
//        public Builder(String name){
//            this.name = name;
//        }
//        public Builder setName(String name) {
//            this.name = name;
//            return this;
//        }
//        public Builder setMaxSpeed(int maxSpeed) {
//            this.maxSpeed = maxSpeed;
//            return this;
//        }
//        public Builder setHeight(int height) {
//            this.height = height;
//            return this;
//        }
//        public Builder setWidth(int width) {
//            this.width = width;
//            return this;
//        }
//        public Builder setWheels(int wheels) {
//            this.wheels = wheels;
//            return this;
//        }
//
//        public Car build() {
//            return new Car(this);
//        }
//    }
//}








//                                      -------ADAPTER-------

//public class Main {
//    public static void main(String[] args) {
//        Driver driver = new Driver();
//        Car toyota = new Toyota();
//        Automobile lada = new Lada();
//        driver.drive(toyota);
//        driver.drive(new AutomobileToCarWrapper(new Lada()));
//    }
//}
//
//class AutomobileToCarWrapper implements Car {
//    Automobile car;
//
//    @Override
//    public void go() {
//        car.drive();
//    }
//
//    public AutomobileToCarWrapper(Automobile car) {
//        this.car = car;
//    }
//}
//
//
//interface Car {
//    void go();
//}
//
//interface Automobile {
//    void drive();
//}
//
//class Toyota implements Car {
//    @Override
//    public void go() {
//        System.out.println(this.getClass().getName() + " goes");
//    }
//}
//
//class Lada implements Automobile {
//    @Override
//    public void drive() {
//        System.out.println(this.getClass().getName() + " drives");
//    }
//}
//
//class Driver {
//    public void drive(Car car){
//        car.go();
//    }
//}







//                                      --------BRIDGE-------
//
//public class Main {
//    public static void main(String[] args) {
//        Car bmw = new Coupe(new BMW());
//        Car audi = new Hatchback(new Audi());
//        bmw.printDetails();
//        audi.printDetails();
//    }
//}
//
//abstract class Car {
//    private Creator creator;    //CREATOR
//    Car(Creator creator) {
//        this.creator = creator;
//    }
//    void printDetails() {
//        System.out.println(getClass().getName());
//        creator.printCreator();
//    }
//}
//class Hatchback extends Car { Hatchback(Creator creator) { super(creator); }}
//class Coupe extends Car { Coupe(Creator creator) { super(creator); }}
//
//abstract class Creator { void printCreator() { System.out.println(getClass().getName()); }}
//class BMW extends Creator { }
//class Audi extends Creator { }






//                                      ------FILTER------
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Main {
//    public static void main(String[] args) {
//        List<Car> cars = new ArrayList<>();
//        cars.add(new Car(2,80));
//        cars.add(new Car(3,110));
//        cars.add(new Car(4,160));
//        cars.add(new Car(2,90));
//        cars.add(new Car(4,105));
//        cars = SpeedFilter.filter(cars);
//
//        System.out.println(cars);
//    }
//}
//
//class Car {
//    int doors;
//    int maxSpeed;
//
//    public Car(int doors, int maxSpeed) {
//        this.doors = doors;
//        this.maxSpeed = maxSpeed;
//    }
//
//    public int getDoors() {
//        return doors;
//    }
//    public int getMaxSpeed() {
//        return maxSpeed;
//    }
//
//    @Override
//    public String toString() {
//        return "Doors: " + doors + '\n' + "MaxSpeed: " + maxSpeed + '\n';
//    }
//}
//
//class SpeedFilter {
//    static List<Car> filter(List<Car> cars) {
//        List<Car> result = new ArrayList<>();
//        for (Car car : cars)
//            if(car.getMaxSpeed() > 100)
//                result.add(car);
//        return result;
//    }
//}







//                                            ------COMPOSITE------

//import java.util.ArrayList;
//import java.util.List;
//
//public class Main {
//    public static void main(String[] args) {
//        Folder folder = new Folder("dir1");
//        folder.add(new Folder("dir12"));
//        folder.add(new Folder("dir13"));
//        folder.add(new File("file11"));
//        folder.add(new File("file12"));
//    }
//}
//
//class Folder {
//    String name;
//    List<Folder> folders = new ArrayList<>();
//    List<File> files = new ArrayList<>();
//
//    public Folder(String name) {
//        this.name = name;
//    }
//    public void add(File file) {
//        files.add(file);
//    }
//    public void add(Folder folder) {
//        folders.add(folder);
//    }
//}
//
//class File {
//    String name;
//    public File(String name) {
//        this.name = name;
//    }
//}

//                                       -----DECORATOR-----

//public class Main {
//    public static void main(String[] args) {
//        PrinterInterface p = new QuotesDecorator(new BracketDecorator(new Printer("hello")));
//        p.print();
//    }
//}
//
//interface PrinterInterface {
//    void print();
//}
//
//class Printer implements PrinterInterface {
//    String value;
//
//    public Printer(String value) {
//        this.value = value;
//    }
//    @Override
//    public void print() {
//        System.out.print(value);
//    }
//}
//
//abstract class Decorator implements PrinterInterface {
//    PrinterInterface component;
//    public Decorator(PrinterInterface component) {
//        this.component = component;
//    }
//    abstract public void print();
//}
//
//class QuotesDecorator extends Decorator {
//    public QuotesDecorator(PrinterInterface printerInterface) {
//        super(printerInterface);
//    }
//
//    @Override
//    public void print() {
//        System.out.print("\"");
//        component.print();
//        System.out.print("\"");
//    }
//}
//
//class BracketDecorator extends Decorator {
//    public BracketDecorator(PrinterInterface component) {
//        super(component);
//    }
//
//    @Override
//    public void print() {
//        System.out.print("[");
//        component.print();
//        System.out.print("]");
//    }
//}








//                                       ------FlyWeight------

//import java.util.HashMap;
//import java.util.Map;
//
//public class Main {
//    public static void main(String[] args) {
//        Garage garage = new Garage();
//        Car car = garage.getCar("green"); //если зелёной машины нет - создает и берёт
//        Car car2 = garage.getCar("green"); //если уже есть зелёная машина - берёт
//        System.out.println("car's color is " + car.color);
//    }
//}
//
//class Car {
//    String color;
//
//    public Car(String color) {
//        this.color = color;
//    }
//}
//
//class Garage {
//    Map<String, Car> garage = new HashMap<>();
//    Car getCar(String color) {
//        Car car = garage.get(color);
//        if(car == null) {
//            car = new Car(color);
//            garage.put(color, car);
//        }
//        return car;
//    }
//}







//                                    ------PROXY---------

//public class Main {
//    public static void main(String[] args) {
//
//    }
//}
//
//interface CarI {
//    void drive();
//}
//
//class CarProxy implements CarI{ //Промежуточная обработка объекта машины
//    CarI car = new Audi();
//    @Override
//    public void drive() {
//        /*
//        some extra code
//         */
//        car.drive();
//    }
//}
//
//class Audi implements CarI {
//    @Override
//    public void drive() {
//        System.out.println("driving " + getClass().getName());
//    }
//}







//                                  -----CHAIN OF RESPONSIBILITY-----

//public class Main {
//    public static void main(String[] args) {
//        MessagePrinter messagePrinter = new MessagePrinter();
//        messagePrinter.setNextMessagePrinter(new MessagePrinter());
//        messagePrinter.setNextMessagePrinter(new MessagePrinter());
//        messagePrinter.setNextMessagePrinter(new MessagePrinter());
//        messagePrinter.setNextMessagePrinter(new MessagePrinter());
//        messagePrinter.setNextMessagePrinter(new MessagePrinter());
//        messagePrinter.print();
//    }
//}
//
//class MessagePrinter {
//    private MessagePrinter nextMessagePrinter;
//    private String message = "message";
//
//    void setNextMessagePrinter(MessagePrinter messagePrinter) {
//        if(nextMessagePrinter == null)
//            nextMessagePrinter = messagePrinter;
//        else
//            nextMessagePrinter.setNextMessagePrinter(messagePrinter);
//    }
//    void print() {
//        System.out.println(message);
//        if(nextMessagePrinter != null)
//            nextMessagePrinter.print();
//    }
//}






//                                      -----COMMAND------
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Main {
//    public static void main(String[] args) {    //ради инкапсуляции
//        Receiver receiver = new Receiver(); //создаём приёмник команд
//        receiver.add(new MouseClick());     //добавляем в него две
//        receiver.add(new MouseReleased());  //разных команды
//        receiver.run();       //запускаем все (разные) команды
//    }
//}
//
//class Receiver {
//    List<Command> commands = new ArrayList<>();
//
//    void add(Command command) {
//        commands.add(command);
//    }
//    void run() {
//        for (Command command : commands) {
//            command.execute();
//        }
//    }
//}
//
//interface Command {
//    void execute();
//}
//
//class MouseClick implements Command {
//    @Override
//    public void execute() {
//        System.out.println("Mouse clicked");
//    }
//}
//
//class MouseReleased implements Command {
//    @Override
//    public void execute() {
//        System.out.println("Mouse released");
//    }
//}





//                                            -----ITERATOR-----

//public class Main {
//    public static void main(String[] args) {
//        ArrayContainer container = new ArrayContainer();
//        Iterator i = container.getIterator();
//        while(i.hasNext())
//            System.out.println(i.next());
//    }
//}
//
//interface Iterator {        //
//    boolean hasNext();      //   !!!!!!!!!!!!!!
//    Object next();          //   !!!!!!!!!!!!!!
//}
//
//interface Container {
//    Iterator getIterator();
//}
//
//class ArrayContainer implements Container{
//    private String[] array = {"gleb","gleb2","gleb3"};
//
//    @Override
//    public Iterator getIterator() {
//        return new ArrayIterator();
//    }
//
//    class ArrayIterator implements Iterator {
//        int index;
//
//        @Override
//        public boolean hasNext() {
//            return index < array.length;
//        }
//
//        @Override
//        public Object next() {
//            if(hasNext())
//                return array[index++];
//            return null;
//        }
//    }
//}






//                                     -----MEDIATOR----- (CHAT)

//import java.util.ArrayList;
//import java.util.List;
//
//public class Main {
//
//    public static void main(String[] args) {
//        ConcreteMediator chat = new ConcreteMediator();
//
//        User user = new User(chat);
//        Admin admin = new Admin(chat);
//
//        chat.addColleague(user);
//        chat.addColleague(admin);
//
//        user.send("How are you?");
//        admin.send("Fine, thanks");
//    }
//}
//
//abstract class Colleague {
//
//    Mediator mediator;
//
//    public Colleague(Mediator mediator) {
//        this.mediator = mediator;
//    }
//
//    public void send(String message) {
//        System.out.println(getClass().getName() + " sends: " + message);
//        mediator.send(message, this);
//    }
//
//    public abstract void notify(String message);
//}
//
//abstract class Mediator {
//    public abstract void send(String message, Colleague sender);
//}
//
//class User extends Colleague {
//
//    public User(Mediator mediator) {
//        super(mediator);
//    }
//
//    @Override
//    public void notify(String message) {
//        System.out.println(getClass().getName() + " gets message: " + message);
//    }
//}
//
//class Admin extends Colleague {
//
//    public Admin(Mediator mediator) {
//        super(mediator);
//    }
//
//    @Override
//    public void notify(String message) {
//        System.out.println(getClass().getName() + " gets message: " + message);
//    }
//}
//
//class ConcreteMediator extends Mediator {
//
//    private List<Colleague> colleagues = new ArrayList<>();
//
//    public void addColleague(Colleague colleague) {
//        colleagues.add(colleague);
//    }
//
//    @Override
//    public void send(String message, Colleague sender) {
//        for (Colleague colleague : colleagues )
//            colleague.notify(message);
//    }
//}




//                               ------MEMENTO-----
//
//public class Main {
//    public static void main(String[] args) {
//        Car redCar = new Car("red",50);
//        Car blueCar = new Car("blue",100);
//
//        Memento<Car> redCarMemento = redCar.createMemento();
//        redCar.setMaxSpeed(555);
//        redCar.setColor("grey");
//        redCar.getStateFromMemento(redCarMemento);
//        System.out.println(redCar);
//    }
//}
//
//class Car {
//    private String color;
//    private int maxSpeed;
//
//    public Car(String color, int maxSpeed) {
//        this.color = color;
//        this.maxSpeed = maxSpeed;
//    }
//
//    public String getColor() {
//        return color;
//    }
//    public void setColor(String color) {
//        this.color = color;
//    }
//    public int getMaxSpeed() {
//        return maxSpeed;
//    }
//    public void setMaxSpeed(int maxSpeed) {
//        this.maxSpeed = maxSpeed;
//    }
//
//    Memento<Car> createMemento() {
//        return new Memento<Car>(new Car(color,maxSpeed));
//    }
//
//    void getStateFromMemento(Memento<Car> memento) {
//        setColor(memento.getState().getColor());
//        setMaxSpeed(memento.getState().getMaxSpeed());
//    }
//
//    @Override
//    public String toString() {
//        return "{color: " + color + ", maxSpeed: " + maxSpeed + "}\n";
//    }
//}
//
//class Memento <T>{
//    private T state;
//
//    public Memento(T state) {
//        this.state = state;
//    }
//    public T getState() {
//        return state;
//    }
//    public void setState(T state) {
//        this.state = state;
//    }
//}





//                                  ------OBSERVER------

//import java.io.File;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.ArrayList;
//import java.util.List;
//
//public class Main {
//    public static void main(String[] args) {
//        MeteoStation meteoStation = new MeteoStation();
//        Observer observer1 = new ConsoleObserver();
//        Observer observer2 = new FileObserver();
//        meteoStation.addObserver(observer1);
//        meteoStation.addObserver(observer2);
//        meteoStation.setMeasurements(35,70);
//        meteoStation.setMeasurements(55,120);
//        meteoStation.setMeasurements(75,180);
//        meteoStation.setMeasurements(97,495);
//    }
//}
//
//interface Observed {
//    void addObserver(Observer o);
//    void removeObserver(Observer o);
//    void notifyObservers();
//}
//
//class MeteoStation implements Observed {
//    int temperature;
//    int pressure;
//
//    public void setMeasurements(int temperature, int pressure) {
//        this.temperature = temperature;
//        this.pressure = pressure;
//        notifyObservers();
//    }
//
//    List<Observer> observers = new ArrayList<>();
//
//    @Override
//    public void addObserver(Observer o) {
//        observers.add(o);
//    }
//
//    @Override
//    public void removeObserver(Observer o) {
//        observers.remove(o);
//    }
//
//    @Override
//    public void notifyObservers() {
//        for(Observer o : observers)
//            o.handleEvent(temperature, pressure);
//    }
//}
//
//interface Observer {
//    void handleEvent(int temp, int pres);
//}
//
//class ConsoleObserver implements Observer {
//    @Override
//    public void handleEvent(int temp, int pres) {
//        System.out.println("[" + hashCode() + "] The weather has changed! "+ "Temperature: " + temp + " Pressure: " + pres);
//    }
//}
//
//class FileObserver implements Observer {
//    @Override
//    public void handleEvent(int temp, int pres) {
//        try {                                                    //C:\Users\HLEB\AppData\Local\Temp
//            PrintWriter printWriter = new PrintWriter(File.createTempFile("TempPressure","_txt"));
//            printWriter.println("[" + hashCode() + "] The weather has changed! Temperature: " + temp + " Pressure: " + pres);
//            printWriter.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}






//                                     ------STATE------
//
//public class Main {
//    public static void main(String[] args) {
//        Element element = new Element(new LowerCaseState(), "Gleb");
//        element.doAction();
//        element.setState(new UpperCaseState());
//        element.doAction();
//    }
//}
//
//interface State {
//    void doAction(Element element);
//}
//
//class LowerCaseState implements State {
//    @Override
//    public void doAction(Element element) {
//        System.out.println(element.name.toLowerCase());
//    }
//}
//
//class UpperCaseState implements State {
//    @Override
//    public void doAction(Element element) {
//        System.out.println(element.name.toUpperCase());
//    }
//}
//
//class Element {
//    State state;
//    String name;
//
//    public Element(State state, String name) {
//        this.state = state;
//        this.name = name;
//    }
//
//    public void setState(State state) {
//        this.state = state;
//    }
//
//    public void doAction() {
//        state.doAction(this);
//    }
//}







//                                        -----