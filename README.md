
# Low Level Design (LLD) — 2 Month Interview Prep Roadmap
**Duration:** 8 Weeks | **Daily Time:** 1.5 Hours | **Language:** Java
---

## OVERVIEW

| Metric | Value |
|---|---|
| Total weeks | 8 |
| Total hours | ~84 |
| Design patterns covered | 23 |
| Practice problems | 12 |
| Daily commitment | 1.5 hrs |

### What LLD interviews actually test
- Can you write clean, working Java code in 45 minutes?
- Do you know which design pattern fits a given problem?
- Can you identify OOP/SOLID violations in code?
- Can you extend a design when requirements change?

### Phase summary
- Phase 1 (Wk 1–2): OOP foundations + SOLID principles
- Phase 2 (Wk 3–4): Creational + Structural design patterns
- Phase 3 (Wk 5–6): Behavioral design patterns
- Phase 4 (Wk 7–8): End-to-end practice problems

---

## PHASE 1 — OOP FOUNDATIONS & SOLID PRINCIPLES

### Week 1 — The 4 OOP Pillars (with Java examples)

**Encapsulation**
- Private fields, public getters/setters
- Why it matters: control over internal state
- Practice: write a BankAccount class with balance as private

**Abstraction**
- Abstract classes vs interfaces — when to use which
- In Java: interface for "can-do", abstract class for "is-a"
- Practice: design a Shape hierarchy with abstract area()

**Inheritance**
- is-a vs has-a relationship
- Avoid deep inheritance hierarchies (max 2 levels)
- Practice: Animal → Dog, Cat with overridden speak()

**Polymorphism**
- Method overriding (runtime) vs overloading (compile-time)
- Runtime dispatch — how Java picks which method to call
- Practice: List<Shape> with different area() calls

**Composition over Inheritance**
- The single most important OOP principle
- Instead of extending, hold a reference to the dependency
- Practice: rewrite an inheritance example using composition

**UML Class Diagrams (basics)**
- Association: A uses B
- Aggregation: A has B (B can exist without A)
- Composition: A owns B (B cannot exist without A)
- Dependency: A depends on B temporarily
- Know how to draw and read these — interviewers draw on whiteboards

> TIP: Every concept in Week 1 should be coded in Java.
> Don't just read — write a 30–50 line example for each pillar.

---

### Week 2 — SOLID Principles (asked directly in interviews)

**S — Single Responsibility Principle**
- One class should have one reason to change
- Bad: UserService that handles login + sends emails + writes to DB
- Good: UserService + EmailService + UserRepository (separate classes)
- Practice: take a fat class and split it into SRP-compliant classes

**O — Open/Closed Principle**
- Open for extension, closed for modification
- Bad: if/else chain that changes every time a new shape is added
- Good: Shape interface with area() — add new shapes without touching existing code
- Practice: discount calculator using OCP (no if/else for new discount types)

**L — Liskov Substitution Principle**
- A subclass must be fully substitutable for its parent
- Classic violation: Square extends Rectangle — setting width breaks area()
- Practice: identify the LSP violation in Rectangle/Square and fix it

**I — Interface Segregation Principle**
- Don't force a class to implement methods it doesn't need
- Bad: Worker interface with work() + eat() + sleep() — robots don't eat
- Good: Workable, Eatable, Sleepable as separate interfaces
- Practice: split a fat interface into focused ones

**D — Dependency Inversion Principle**
- Depend on abstractions (interfaces), not concrete classes
- Bad: OrderService directly creates MySQLRepository
- Good: OrderService depends on IRepository, inject MySQLRepository at runtime
- This is the foundation of Spring Boot's dependency injection
- Practice: refactor a hardcoded dependency to use an interface + constructor injection

> TIP: SOLID violations are asked as "what's wrong with this code?" questions.
> Practice spotting violations, not just reciting definitions.

---

## PHASE 2 — CREATIONAL & STRUCTURAL PATTERNS

### Week 3 — Creational Patterns (5 patterns)

**1. Singleton**
- Intent: ensure only one instance of a class exists
- Use when: Logger, Config manager, DB connection pool
- Java implementation: lazy initialization with double-checked locking
- Thread-safe version:
  ```java
  private static volatile Singleton instance;
  public static Singleton getInstance() {
      if (instance == null) {
          synchronized (Singleton.class) {
              if (instance == null) instance = new Singleton();
          }
      }
      return instance;
  }
  ```
- Interview frequency: VERY HIGH — almost always asked

**2. Factory Method**
- Intent: let subclass decide which object to create
- Use when: you need to create objects but don't know the exact type upfront
- Example: ShapeFactory.create("circle") returns a Circle
- Example: NotificationFactory.create("email") returns EmailNotification
- Interview frequency: HIGH

**3. Abstract Factory**
- Intent: create families of related objects
- Use when: UI toolkit (Windows buttons vs Mac buttons)
- Example: GUIFactory with createButton() + createCheckbox()
- Interview frequency: MEDIUM — understand it, don't over-invest

**4. Builder**
- Intent: construct complex objects step by step
- Use when: object has many optional parameters (avoid telescoping constructors)
- You already use this: Lombok @Builder, StringBuilder, HttpRequest.Builder
- Practice: build a Pizza class with Builder (size, crust, toppings)
- Interview frequency: HIGH — asked directly and used in coding problems

**5. Prototype**
- Intent: clone existing objects instead of creating from scratch
- Use when: object creation is expensive, or you need slightly varied copies
- Java: implement Cloneable + override clone()
- Know shallow copy vs deep copy difference
- Interview frequency: LOW — know the concept, don't invest heavily

---

### Week 4 — Structural Patterns (6 patterns)

**1. Adapter**
- Intent: make incompatible interfaces work together
- Use when: integrating third-party APIs with your existing code
- Example: payment gateway has different interface than your PaymentProcessor
- Real-world: you probably write Adapters at Mastercard for external systems
- Interview frequency: HIGH at MNCs

**2. Decorator**
- Intent: add behavior to objects without changing their class
- Use when: you want to add features dynamically at runtime
- Java I/O is built on Decorator: new BufferedReader(new FileReader(file))
- Practice: Coffee class with add-ons (milk, sugar, syrup) as decorators
- Interview frequency: HIGH

**3. Facade**
- Intent: simplified interface to a complex subsystem
- Use when: hiding internal complexity from the caller
- Example: OrderFacade.placeOrder() internally calls InventoryService + PaymentService + ShippingService
- Every Spring Boot service layer is effectively a Facade
- Interview frequency: MEDIUM-HIGH

**4. Proxy**
- Intent: control access to an object
- Types: Virtual (lazy loading), Protection (access control), Remote (network calls)
- Spring's @Transactional, @Cacheable use Proxy pattern internally
- Practice: build a protection proxy that checks user role before calling a method
- Interview frequency: MEDIUM

**5. Composite**
- Intent: treat individual objects and groups of objects uniformly
- Use when: dealing with tree structures
- Example: File and Folder both implement FileComponent — getSize() works on both
- Example: UI components where containers and leaves share the same interface
- Interview frequency: MEDIUM

**6. Bridge**
- Intent: decouple abstraction from its implementation
- Use when: you want to vary abstraction and implementation independently
- Example: RemoteControl abstraction works with any TV implementation
- Interview frequency: LOW — know the intent, skip deep implementation

> TIP: For each pattern: (1) read the intent on refactoring.guru,
> (2) study the class diagram, (3) code the example in Java from scratch.
> No copy-paste. Typing it out builds muscle memory for interviews.

---

## PHASE 3 — BEHAVIORAL PATTERNS

### Week 5 — Core Behavioral Patterns (highest interview frequency)

**1. Observer** ⭐ Most important behavioral pattern
- Intent: when one object changes state, notify all dependents automatically
- Use when: event-driven systems, notification systems, pub-sub
- Example: StockTicker (subject) notifies multiple Investors (observers)
- Example: NotificationService notifies Email + SMS + Push channels
- Java: built into java.util.Observable (legacy) — better to implement yourself
- Practice: implement a simple event bus using Observer
- Interview frequency: VERY HIGH

**2. Strategy** ⭐
- Intent: define a family of algorithms, make them interchangeable
- Use when: you need to swap behavior at runtime
- Example: PaymentContext with strategies (CreditCard, UPI, Wallet, NetBanking)
- Example: SortingContext with strategies (BubbleSort, QuickSort, MergeSort)
- This is directly relevant to your payments work at Mastercard
- Practice: build a payment method selector using Strategy
- Interview frequency: VERY HIGH

**3. State** ⭐
- Intent: object changes behavior when its internal state changes
- Use when: object has distinct states with different behavior per state
- Example: VendingMachine states: Idle → ItemSelected → HasMoney → Dispensing
- Example: Order states: Placed → Confirmed → Shipped → Delivered → Cancelled
- Example: TrafficLight: Red → Green → Yellow → Red
- Practice: implement a full VendingMachine using State pattern
- Interview frequency: VERY HIGH — appears in almost every machine coding round

**4. Command**
- Intent: encapsulate a request as an object
- Use when: you need undo/redo, request queuing, or audit logging
- Example: TextEditor with undo — each action (type, delete, format) is a Command
- Example: Remote control where each button is a Command object
- Practice: implement undo/redo for a simple text editor
- Interview frequency: MEDIUM-HIGH

**5. Template Method**
- Intent: define algorithm skeleton in base class, let subclasses fill in the steps
- Use when: multiple classes share the same algorithm structure with varying steps
- Example: DataProcessor with steps: readData() → processData() → writeData()
- Subclasses override individual steps, not the whole algorithm
- Practice: build a report generator where CSV and PDF reports share the same flow
- Interview frequency: MEDIUM

---

### Week 6 — Remaining Behavioral Patterns (Optional)

**6. Chain of Responsibility**
- Intent: pass request along a chain of handlers until one handles it
- Use when: middleware pipelines, approval workflows, validation chains
- Example: API request goes through AuthHandler → RateLimitHandler → LoggingHandler → BusinessHandler
- Example: expense approval chain: Employee → Manager → Director → CEO based on amount
- Practice: build a middleware chain for an HTTP request
- Interview frequency: MEDIUM-HIGH

**7. Iterator**
- Intent: access elements of a collection without exposing its internals
- Java already uses this: every for-each loop uses the Iterator pattern
- Know how to implement Iterable + Iterator for a custom data structure
- Interview frequency: LOW — you use it daily, rarely asked to implement from scratch

**8. Mediator**
- Intent: objects communicate through a central mediator instead of directly
- Use when: many objects talk to each other (reduces coupling)
- Example: Chat room where users send messages to the ChatRoom, not to each other directly
- Example: Air traffic control — planes communicate through the tower
- Practice: implement a simple chat room using Mediator
- Interview frequency: MEDIUM

**9. Memento**
- Intent: capture and restore an object's state without exposing internals
- Use when: implementing undo functionality or saving/restoring state
- Example: game save/load, text editor undo
- Three participants: Originator (has state), Memento (stores state), Caretaker (manages mementos)
- Interview frequency: MEDIUM

**10. Visitor**
- Intent: add new operations to objects without modifying their classes
- Use when: you need to add many unrelated operations to a class hierarchy
- Example: tax calculator that visits different order items (Book, Food, Electronics — different tax rates)
- Interview frequency: LOW-MEDIUM

**11. Interpreter**
- Intent: define a grammar for a language and interpret sentences
- Example: SQL parser, expression evaluator, regex engine
- Interview frequency: VERY LOW — skim only, understand the concept

> TIP: Observer + Strategy + State are the behavioral trinity.
> They appear in almost every practice problem. Learn these three deeply
> before moving to the rest of Week 6.

---

## PHASE 4 — END-TO-END PRACTICE PROBLEMS
---

### Week 7 — Core Problems (do these first)

**Problem 1: Parking Lot** [Easy]
- Entities: Vehicle (Car/Bike/Truck), ParkingSpot (Small/Medium/Large), Ticket, Payment
- Key patterns: Factory (vehicle types), Strategy (pricing per vehicle type), State (spot availability)
- Key methods: park(vehicle), unpark(ticket), calculateFee(ticket)
- Edge cases: full lot, invalid ticket, multiple floors
- Time target: 40 minutes

**Problem 2: Vending Machine** [Easy]
- Pure State pattern showcase
- States: Idle → ItemSelected → HasMoney → Dispensing → OutOfStock
- Key classes: VendingMachine, State (interface), Item, Inventory
- Each state implements: selectItem(), insertMoney(), dispense(), returnChange()
- Time target: 35 minutes

**Problem 3: Elevator System** [Easy-Medium]
- Entities: Elevator, Floor, Request, ElevatorController
- Key patterns: State (elevator states: MOVING_UP, MOVING_DOWN, IDLE, DOOR_OPEN), Observer (floor requests)
- Dispatcher algorithm: which elevator picks up a request?
- Time target: 45 minutes

**Problem 4: Library Management System** [Easy-Medium]
- Entities: Book, Member, Librarian, BorrowRecord, Catalog
- Key patterns: Singleton (Catalog), Observer (overdue alerts), Strategy (search: by title/author/ISBN)
- Key methods: borrowBook(), returnBook(), searchBook(), calculateFine()
- Time target: 45 minutes

**Problem 5: ATM Machine** [Medium]
- Key patterns: State (Idle → CardInserted → PINEntered → TransactionInProgress), Chain of Responsibility (AuthHandler → BalanceCheckHandler → DispenseHandler), Singleton (BankService)
- Entities: ATM, Card, Account, Transaction, CashDispenser
- Time target: 45 minutes

---

### Week 8 — Advanced Problems

**Problem 6: Chess / Tic-Tac-Toe** [Medium]
- Start with Tic-Tac-Toe (30 min), then Chess (45 min)
- Entities: Board, Player, Piece (King/Queen/Rook/Knight/Bishop/Pawn), Move
- Key patterns: Strategy (move validation per piece type), Factory (piece creation)
- Focus: extensible piece movement, turn management, win condition check

**Problem 7: Movie Ticket Booking (BookMyShow)** [Medium]
- Entities: Theater, Screen, Show, Seat, Booking, User
- Key challenge: concurrent seat reservation — two users booking same seat simultaneously
- Key patterns: Observer (seat lock expiry), Strategy (seat selection algorithm)
- Key methods: searchShows(), selectSeats(), lockSeats(), confirmBooking(), cancelBooking()
- Time target: 50 minutes
- Note: very commonly asked at Razorpay, Flipkart, Zepto

**Problem 8: Hotel Management System** [Medium]
- Entities: Hotel, Room (Single/Double/Suite), Reservation, Guest, HouseKeepingStaff
- Key patterns: Factory (room types), State (room status: AVAILABLE/OCCUPIED/MAINTENANCE), Observer (housekeeping trigger on checkout)
- Key methods: searchRooms(), makeReservation(), checkIn(), checkOut()
- Time target: 45 minutes

**Problem 9: Online Food Ordering (Zomato-lite)** [Medium]
- Entities: Restaurant, Menu, MenuItem, Cart, Order, DeliveryAgent
- Key patterns: Strategy (restaurant ranking, delivery assignment), State (order: PLACED → CONFIRMED → PREPARING → OUT_FOR_DELIVERY → DELIVERED), Observer (push notifications on state change)
- Time target: 50 minutes

**Problem 10: Cab Booking (Uber-lite)** [Medium-Hard]
- Entities: Driver, Rider, Ride, Location, Rating
- Key patterns: Strategy (driver matching algorithm, surge pricing), State (ride lifecycle: REQUESTED → ACCEPTED → IN_PROGRESS → COMPLETED), Observer (location updates)
- Time target: 50 minutes
- Note: favourite at Razorpay, Zepto, Swiggy interviews

**Problem 11: Notification System** [Medium]
- Pure Observer pattern at scale
- Entities: NotificationService, Channel (Email/SMS/Push), UserPreference, NotificationTemplate
- Features: user preferences (subscribe/unsubscribe per channel), retry on failure, template rendering
- This is directly relevant to your Mastercard work — build it well
- Time target: 40 minutes

**Problem 12: Payment Gateway ** [Medium-Hard]
- Entities: PaymentRequest, Transaction, PaymentMethod, MerchantAccount, Ledger
- Key patterns: Strategy (payment methods: Card/UPI/Wallet), Chain of Responsibility (FraudCheckHandler → AuthHandler → SettlementHandler → WebhookHandler), Observer (webhook callbacks to merchants), Builder (Transaction object)
- Key concepts: idempotency, retry with exponential backoff, partial failure handling
- Lead with your Mastercard domain knowledge here — no other candidate has this context
- Time target: 55 minutes

---
### The Interview Framework (use this every single time)

```
Step 1 — Clarify requirements (3 min)
  - What features are in scope?
  - Any constraints? Scale?

Step 2 — Identify core entities (5 min)
  - List all nouns from the problem → these are your classes
  - Identify relationships between them

Step 3 — Draw class diagram (5 min)
  - Attributes and methods for each class
  - Relationships: association, aggregation, composition
  - Note which design patterns you'll use and where

Step 4 — Write code (15–20 min)
  - Core classes with key methods
  - At least one design pattern implemented in full
  - Enums for status/type fields
  - Basic error handling

Step 5 — Walk through a use case (5 min)
  - Trace through your code for one end-to-end flow
  - "When a user parks a car, here's what happens..."

Step 6 — Discuss extensibility (2 min)
  - "What if we add monthly subscriptions?"
  - Show how your design handles new requirements cleanly
```
### Resources
- Refactoring Guru — refactoring.guru/design-patterns (best visual explanations)
- Derek Banas — Design Patterns in Java (YouTube) https://www.youtube.com/playlist?list=PLF206E906175C7E07


## ALL 23 DESIGN PATTERNS — QUICK REFERENCE

### Creational (5)

| Pattern | Intent | Java Example | Interview Freq |
|---|---|---|---|
| Singleton | One instance only | Logger, Config, DB pool | Very High |
| Factory Method | Subclass decides creation | ShapeFactory, NotificationFactory | High |
| Abstract Factory | Family of related objects | UI toolkit per OS | Medium |
| Builder | Step-by-step construction | @Builder, HttpRequest | High |
| Prototype | Clone existing objects | Deep copy of config objects | Low |

### Structural (6)

| Pattern | Intent | Java Example | Interview Freq |
|---|---|---|---|
| Adapter | Bridge incompatible interfaces | Payment gateway wrapper | High |
| Decorator | Add behavior dynamically | Java I/O, Pizza toppings | High |
| Facade | Simplified interface | OrderFacade, Spring service layer | Medium-High |
| Proxy | Control access to object | Spring @Transactional, @Cacheable | Medium |
| Composite | Tree of uniform objects | File system, UI components | Medium |
| Bridge | Decouple abstraction from impl | Remote control + devices | Low |

### Behavioral (11)

| Pattern | Intent | Java Example | Interview Freq |
|---|---|---|---|
| Observer ⭐ | Notify dependents on change | Notification system, event bus | Very High |
| Strategy ⭐ | Swap algorithms at runtime | Payment methods, sorting | Very High |
| State ⭐ | Change behavior per state | Vending machine, order lifecycle | Very High |
| Command | Encapsulate action as object | Undo/redo, task queue | Medium-High |
| Template Method | Algorithm skeleton | Data processor, report generator | Medium |
| Chain of Responsibility | Pass request along chain | Middleware, approval workflow | Medium-High |
| Iterator | Sequential access | Java for-each, custom collections | Low |
| Mediator | Centralized communication | Chat room, event bus | Medium |
| Memento | Save and restore state | Undo, game saves | Medium |
| Visitor | Add ops without modifying | Tax calculator, report exporter | Low-Medium |
| Interpreter | Grammar for a language | SQL parser, expression evaluator | Very Low |

---

## DAILY SCHEDULE

### Weeks 1–6 (Learning weeks) — 1.5 hrs/day

| Day | Activity |
|---|---|
| Monday | Read + watch 1–2 concepts or patterns (45 min) |
| Tuesday | Code the pattern from scratch in Java in your IDE (45 min) |
| Wednesday | DSA practice (keep your parallel track going) |
| Thursday | Next pattern — read + watch (45 min) |
| Friday | Code Thursday's pattern + one mini-design problem (30+30 min) |
| Saturday | One full LLD problem end-to-end, timed 45 min, then review (1.5 hrs) |
| Sunday | Revise the week's patterns, update your personal cheatsheet |
