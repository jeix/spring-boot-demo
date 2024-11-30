# Lombok

### `@Builder`

```java
package org.simple.demo.lombok;

import lombok.Builder;
import lombok.Singular;

import java.util.List;

@Builder
public class ABuilder {
    @Builder.Default private long created = System.currentTimeMillis();
    private String name;
    private int age;
    @Singular
    private List<String> books;
}
```

```java
ABuilder x = ABuilder.builder()
        //.created(System.currentTimeMillis())
        .name("고구마")
        .age(42)
        .books(new ArrayList<>() {{
            add("고사리");
            add("고라니");
        }})
        .clearBooks()
        .book("고도리")
        .build();
```

```java
package org.simple.demo.lombok;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ABuilder {
    private long created;
    private String name;
    private int age;
    private List<String> books;

    private static long $default$created() {
        return System.currentTimeMillis();
    }

    ABuilder(final long created, final String name, final int age, final List<String> books) {
        this.created = created;
        this.name = name;
        this.age = age;
        this.books = books;
    }

    public static ABuilderBuilder builder() {
        return new ABuilderBuilder();
    }

    public static class ABuilderBuilder {
        private boolean created$set;
        private long created$value;
        private String name;
        private int age;
        private ArrayList<String> books;

        ABuilderBuilder() {
        }

        public ABuilderBuilder created(final long created) {
            this.created$value = created;
            this.created$set = true;
            return this;
        }

        public ABuilderBuilder name(final String name) {
            this.name = name;
            return this;
        }

        public ABuilderBuilder age(final int age) {
            this.age = age;
            return this;
        }

        public ABuilderBuilder book(final String book) {
            if (this.books == null) {
                this.books = new ArrayList();
            }

            this.books.add(book);
            return this;
        }

        public ABuilderBuilder books(final Collection<? extends String> books) {
            if (books == null) {
                throw new NullPointerException("books cannot be null");
            } else {
                if (this.books == null) {
                    this.books = new ArrayList();
                }

                this.books.addAll(books);
                return this;
            }
        }

        public ABuilderBuilder clearBooks() {
            if (this.books != null) {
                this.books.clear();
            }

            return this;
        }

        public ABuilder build() {
            List<String> books;
            switch (this.books == null ? 0 : this.books.size()) {
                case 0 -> books = Collections.emptyList();
                case 1 -> books = Collections.singletonList((String)this.books.get(0));
                default -> books = Collections.unmodifiableList(new ArrayList(this.books));
            }

            long created$value = this.created$value;
            if (!this.created$set) {
                created$value = ABuilder.$default$created();
            }

            return new ABuilder(created$value, this.name, this.age, books);
        }

        public String toString() {
            long var10000 = this.created$value;
            return "ABuilder.ABuilderBuilder(created$value=" + var10000
                    + ", name=" + this.name
					+ ", age=" + this.age
					+ ", books=" + String.valueOf(this.books) + ")";
        }
    }
}
```

### `@NoArgsConstructor` | `@RequiredArgsConstructor` | `@AllArgsConstructor`

```java
package org.simple.demo.lombok;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(staticName = "of")
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class AConstructor<T> {
    private int x, y;
    @NonNull
    private T description;

    @NoArgsConstructor
    public static class NoArgsExample {
        @NonNull private String field;
    }
}
```

```java
AConstructor<String> x = AConstructor.of("이러쿵저렁쿵");

// 'AConstructor(@lombok. NonNull T)' has private access
//AConstructor<String> y = new AConstructor<>("궁시렁궁시렁");

AConstructor<String> y = new AConstructor<>(123, 45, "궁시렁궁시렁");

AConstructor.NoArgsExample z = new AConstructor.NoArgsExample();
```

```java
package org.simple.demo.lombok;

import lombok.NonNull;

public class AConstructor<T> {
    private int x;
    private int y;
    private @NonNull T description;

    private AConstructor(final @NonNull T description) {
        if (description == null) {
            throw new NullPointerException("description is marked non-null but is null");
        } else {
            this.description = description;
        }
    }

    public static <T> AConstructor<T> of(final @NonNull T description) {
        if (description == null) {
            throw new NullPointerException("description is marked non-null but is null");
        } else {
            return new AConstructor<T>(description);
        }
    }

    protected AConstructor(final int x, final int y, final @NonNull T description) {
        if (description == null) {
            throw new NullPointerException("description is marked non-null but is null");
        } else {
            this.x = x;
            this.y = y;
            this.description = description;
        }
    }

    public static class NoArgsExample {
        private @NonNull String field;

        public NoArgsExample() {
        }
    }
}
```

----------------------------------------

### `val`

```java
// Lombok

import java.util.ArrayList;
import java.util.HashMap;
import lombok.val;

public class ValExample {
  public String example() {
    val example = new ArrayList<String>();
    example.add("Hello, World!");
    val foo = example.get(0);
    return foo.toLowerCase();
  }
  
  public void example2() {
    val map = new HashMap<Integer, String>();
    map.put(0, "zero");
    map.put(5, "five");
    for (val entry : map.entrySet()) {
      System.out.printf("%d: %s\n", entry.getKey(), entry.getValue());
    }
  }
}
```
```java
// Vanilla Java

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ValExample {
  public String example() {
    final ArrayList<String> example = new ArrayList<String>();
    example.add("Hello, World!");
    final String foo = example.get(0);
    return foo.toLowerCase();
  }
  
  public void example2() {
    final HashMap<Integer, String> map = new HashMap<Integer, String>();
    map.put(0, "zero");
    map.put(5, "five");
    for (final Map.Entry<Integer, String> entry : map.entrySet()) {
      System.out.printf("%d: %s\n", entry.getKey(), entry.getValue());
    }
  }
}
```

### `var`

```java
// Lombok

```
```java
// Vanilla Java

```

### `@NonNull`

```java
// Lombok

import lombok.NonNull;

public class NonNullExample extends Something {
  private String name;
  
  public NonNullExample(@NonNull Person person) {
    super("Hello");
    this.name = person.getName();
  }
}
```
```java
// Vanilla Java

import lombok.NonNull;

public class NonNullExample extends Something {
  private String name;
  
  public NonNullExample(@NonNull Person person) {
    super("Hello");
    if (person == null) {
      throw new NullPointerException("person is marked non-null but is null");
    }
    this.name = person.getName();
  }
}
```

### `@Cleanup`

```java
// Lombok

import lombok.Cleanup;
import java.io.*;

public class CleanupExample {
  public static void main(String[] args) throws IOException {
    @Cleanup InputStream in = new FileInputStream(args[0]);
    @Cleanup OutputStream out = new FileOutputStream(args[1]);
    byte[] b = new byte[10000];
    while (true) {
      int r = in.read(b);
      if (r == -1) break;
      out.write(b, 0, r);
    }
  }
}
```
```java
// Vanilla Java

import java.io.*;

public class CleanupExample {
  public static void main(String[] args) throws IOException {
    InputStream in = new FileInputStream(args[0]);
    try {
      OutputStream out = new FileOutputStream(args[1]);
      try {
        byte[] b = new byte[10000];
        while (true) {
          int r = in.read(b);
          if (r == -1) break;
          out.write(b, 0, r);
        }
      } finally {
        if (out != null) {
          out.close();
        }
      }
    } finally {
      if (in != null) {
        in.close();
      }
    }
  }
}
```

### `@Getter` | `@Setter`

```java
// Lombok

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

public class GetterSetterExample {
  /**
   * Age of the person. Water is wet.
   * 
   * @param age New value for this person's age. Sky is blue.
   * @return The current value of this person's age. Circles are round.
   */
  @Getter @Setter private int age = 10;
  
  /**
   * Name of the person.
   * -- SETTER --
   * Changes the name of this person.
   * 
   * @param name The new value.
   */
  @Setter(AccessLevel.PROTECTED) private String name;
  
  @Override public String toString() {
    return String.format("%s (age: %d)", name, age);
  }
}
```
```java
// Vanilla Java

public class GetterSetterExample {
  /**
   * Age of the person. Water is wet.
   */
  private int age = 10;

  /**
   * Name of the person.
   */
  private String name;
  
  @Override public String toString() {
    return String.format("%s (age: %d)", name, age);
  }
  
  /**
   * Age of the person. Water is wet.
   *
   * @return The current value of this person's age. Circles are round.
   */
  public int getAge() {
    return age;
  }
  
  /**
   * Age of the person. Water is wet.
   *
   * @param age New value for this person's age. Sky is blue.
   */
  public void setAge(int age) {
    this.age = age;
  }
  
  /**
   * Changes the name of this person.
   *
   * @param name The new value.
   */
  protected void setName(String name) {
    this.name = name;
  }
}
```

### `@ToString`

```java
// Lombok

import lombok.ToString;

@ToString
public class ToStringExample {
  private static final int STATIC_VAR = 10;
  private String name;
  private Shape shape = new Square(5, 10);
  private String[] tags;
  @ToString.Exclude private int id;
  
  public String getName() {
    return this.name;
  }
  
  @ToString(callSuper=true, includeFieldNames=true)
  public static class Square extends Shape {
    private final int width, height;
    
    public Square(int width, int height) {
      this.width = width;
      this.height = height;
    }
  }
}
```
```java
// Vanilla Java

import java.util.Arrays;

public class ToStringExample {
  private static final int STATIC_VAR = 10;
  private String name;
  private Shape shape = new Square(5, 10);
  private String[] tags;
  private int id;
  
  public String getName() {
    return this.name;
  }
  
  public static class Square extends Shape {
    private final int width, height;
    
    public Square(int width, int height) {
      this.width = width;
      this.height = height;
    }
    
    @Override public String toString() {
      return "Square(super=" + super.toString() + ", width=" + this.width + ", height=" + this.height + ")";
    }
  }
  
  @Override public String toString() {
    return "ToStringExample(" + this.getName() + ", " + this.shape + ", " + Arrays.deepToString(this.tags) + ")";
  }
}
```

### `@EqualsAndHashCode`

```java
// Lombok

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class EqualsAndHashCodeExample {
  private transient int transientVar = 10;
  private String name;
  private double score;
  @EqualsAndHashCode.Exclude private Shape shape = new Square(5, 10);
  private String[] tags;
  @EqualsAndHashCode.Exclude private int id;
  
  public String getName() {
    return this.name;
  }
  
  @EqualsAndHashCode(callSuper=true)
  public static class Square extends Shape {
    private final int width, height;
    
    public Square(int width, int height) {
      this.width = width;
      this.height = height;
    }
  }
}
```
```java
// Vanilla Java

import java.util.Arrays;

public class EqualsAndHashCodeExample {
  private transient int transientVar = 10;
  private String name;
  private double score;
  private Shape shape = new Square(5, 10);
  private String[] tags;
  private int id;
  
  public String getName() {
    return this.name;
  }
  
  @Override public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof EqualsAndHashCodeExample)) return false;
    EqualsAndHashCodeExample other = (EqualsAndHashCodeExample) o;
    if (!other.canEqual((Object)this)) return false;
    if (this.getName() == null ? other.getName() != null : !this.getName().equals(other.getName())) return false;
    if (Double.compare(this.score, other.score) != 0) return false;
    if (!Arrays.deepEquals(this.tags, other.tags)) return false;
    return true;
  }
  
  @Override public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final long temp1 = Double.doubleToLongBits(this.score);
    result = (result*PRIME) + (this.name == null ? 43 : this.name.hashCode());
    result = (result*PRIME) + (int)(temp1 ^ (temp1 >>> 32));
    result = (result*PRIME) + Arrays.deepHashCode(this.tags);
    return result;
  }
  
  protected boolean canEqual(Object other) {
    return other instanceof EqualsAndHashCodeExample;
  }
  
  public static class Square extends Shape {
    private final int width, height;
    
    public Square(int width, int height) {
      this.width = width;
      this.height = height;
    }
    
    @Override public boolean equals(Object o) {
      if (o == this) return true;
      if (!(o instanceof Square)) return false;
      Square other = (Square) o;
      if (!other.canEqual((Object)this)) return false;
      if (!super.equals(o)) return false;
      if (this.width != other.width) return false;
      if (this.height != other.height) return false;
      return true;
    }
    
    @Override public int hashCode() {
      final int PRIME = 59;
      int result = 1;
      result = (result*PRIME) + super.hashCode();
      result = (result*PRIME) + this.width;
      result = (result*PRIME) + this.height;
      return result;
    }
    
    protected boolean canEqual(Object other) {
      return other instanceof Square;
    }
  }
}
```

### `@Data`

`@ToString` + `@EqualsAndHashCode` + `@Getter` + `@Setter` + `@RequiredArgsConstructor`

```java
// Lombok

import lombok.AccessLevel;
import lombok.Setter;
import lombok.Data;
import lombok.ToString;

@Data public class DataExample {
  private final String name;
  @Setter(AccessLevel.PACKAGE) private int age;
  private double score;
  private String[] tags;
  
  @ToString(includeFieldNames=true)
  @Data(staticConstructor="of")
  public static class Exercise<T> {
    private final String name;
    private final T value;
  }
}
```
```java
// Vanilla Java

import java.util.Arrays;

public class DataExample {
  private final String name;
  private int age;
  private double score;
  private String[] tags;
  
  public DataExample(String name) {
    this.name = name;
  }
  
  public String getName() {
    return this.name;
  }
  
  void setAge(int age) {
    this.age = age;
  }
  
  public int getAge() {
    return this.age;
  }
  
  public void setScore(double score) {
    this.score = score;
  }
  
  public double getScore() {
    return this.score;
  }
  
  public String[] getTags() {
    return this.tags;
  }
  
  public void setTags(String[] tags) {
    this.tags = tags;
  }
  
  @Override public String toString() {
    return "DataExample(" + this.getName() + ", " + this.getAge() + ", " + this.getScore() + ", " + Arrays.deepToString(this.getTags()) + ")";
  }
  
  protected boolean canEqual(Object other) {
    return other instanceof DataExample;
  }
  
  @Override public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof DataExample)) return false;
    DataExample other = (DataExample) o;
    if (!other.canEqual((Object)this)) return false;
    if (this.getName() == null ? other.getName() != null : !this.getName().equals(other.getName())) return false;
    if (this.getAge() != other.getAge()) return false;
    if (Double.compare(this.getScore(), other.getScore()) != 0) return false;
    if (!Arrays.deepEquals(this.getTags(), other.getTags())) return false;
    return true;
  }
  
  @Override public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final long temp1 = Double.doubleToLongBits(this.getScore());
    result = (result*PRIME) + (this.getName() == null ? 43 : this.getName().hashCode());
    result = (result*PRIME) + this.getAge();
    result = (result*PRIME) + (int)(temp1 ^ (temp1 >>> 32));
    result = (result*PRIME) + Arrays.deepHashCode(this.getTags());
    return result;
  }
  
  public static class Exercise<T> {
    private final String name;
    private final T value;
    
    private Exercise(String name, T value) {
      this.name = name;
      this.value = value;
    }
    
    public static <T> Exercise<T> of(String name, T value) {
      return new Exercise<T>(name, value);
    }
    
    public String getName() {
      return this.name;
    }
    
    public T getValue() {
      return this.value;
    }
    
    @Override public String toString() {
      return "Exercise(name=" + this.getName() + ", value=" + this.getValue() + ")";
    }
    
    protected boolean canEqual(Object other) {
      return other instanceof Exercise;
    }
    
    @Override public boolean equals(Object o) {
      if (o == this) return true;
      if (!(o instanceof Exercise)) return false;
      Exercise<?> other = (Exercise<?>) o;
      if (!other.canEqual((Object)this)) return false;
      if (this.getName() == null ? other.getValue() != null : !this.getName().equals(other.getName())) return false;
      if (this.getValue() == null ? other.getValue() != null : !this.getValue().equals(other.getValue())) return false;
      return true;
    }
    
    @Override public int hashCode() {
      final int PRIME = 59;
      int result = 1;
      result = (result*PRIME) + (this.getName() == null ? 43 : this.getName().hashCode());
      result = (result*PRIME) + (this.getValue() == null ? 43 : this.getValue().hashCode());
      return result;
    }
  }
}
```

### `@Value`

```java
// Lombok

import lombok.AccessLevel;
import lombok.experimental.NonFinal;
import lombok.experimental.Value;
import lombok.experimental.With;
import lombok.ToString;

@Value public class ValueExample {
  String name;
  @With(AccessLevel.PACKAGE) @NonFinal int age;
  double score;
  protected String[] tags;
  
  @ToString(includeFieldNames=true)
  @Value(staticConstructor="of")
  public static class Exercise<T> {
    String name;
    T value;
  }
}
```
```java
// Vanilla Java

import java.util.Arrays;

public final class ValueExample {
  private final String name;
  private int age;
  private final double score;
  protected final String[] tags;
  
  @java.beans.ConstructorProperties({"name", "age", "score", "tags"})
  public ValueExample(String name, int age, double score, String[] tags) {
    this.name = name;
    this.age = age;
    this.score = score;
    this.tags = tags;
  }
  
  public String getName() {
    return this.name;
  }
  
  public int getAge() {
    return this.age;
  }
  
  public double getScore() {
    return this.score;
  }
  
  public String[] getTags() {
    return this.tags;
  }
  
  @java.lang.Override
  public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof ValueExample)) return false;
    final ValueExample other = (ValueExample)o;
    final Object this$name = this.getName();
    final Object other$name = other.getName();
    if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
    if (this.getAge() != other.getAge()) return false;
    if (Double.compare(this.getScore(), other.getScore()) != 0) return false;
    if (!Arrays.deepEquals(this.getTags(), other.getTags())) return false;
    return true;
  }
  
  @java.lang.Override
  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final Object $name = this.getName();
    result = result * PRIME + ($name == null ? 43 : $name.hashCode());
    result = result * PRIME + this.getAge();
    final long $score = Double.doubleToLongBits(this.getScore());
    result = result * PRIME + (int)($score >>> 32 ^ $score);
    result = result * PRIME + Arrays.deepHashCode(this.getTags());
    return result;
  }
  
  @java.lang.Override
  public String toString() {
    return "ValueExample(name=" + getName() + ", age=" + getAge() + ", score=" + getScore() + ", tags=" + Arrays.deepToString(getTags()) + ")";
  }
  
  ValueExample withAge(int age) {
    return this.age == age ? this : new ValueExample(name, age, score, tags);
  }
  
  public static final class Exercise<T> {
    private final String name;
    private final T value;
    
    private Exercise(String name, T value) {
      this.name = name;
      this.value = value;
    }
    
    public static <T> Exercise<T> of(String name, T value) {
      return new Exercise<T>(name, value);
    }
    
    public String getName() {
      return this.name;
    }
    
    public T getValue() {
      return this.value;
    }
    
    @java.lang.Override
    public boolean equals(Object o) {
      if (o == this) return true;
      if (!(o instanceof ValueExample.Exercise)) return false;
      final Exercise<?> other = (Exercise<?>)o;
      final Object this$name = this.getName();
      final Object other$name = other.getName();
      if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
      final Object this$value = this.getValue();
      final Object other$value = other.getValue();
      if (this$value == null ? other$value != null : !this$value.equals(other$value)) return false;
      return true;
    }
    
    @java.lang.Override
    public int hashCode() {
      final int PRIME = 59;
      int result = 1;
      final Object $name = this.getName();
      result = result * PRIME + ($name == null ? 43 : $name.hashCode());
      final Object $value = this.getValue();
      result = result * PRIME + ($value == null ? 43 : $value.hashCode());
      return result;
    }
    
    @java.lang.Override
    public String toString() {
      return "ValueExample.Exercise(name=" + getName() + ", value=" + getValue() + ")";
    }
  }
}
```

### `@SneakyThrows`

```java
// Lombok

import lombok.SneakyThrows;

public class SneakyThrowsExample implements Runnable {
  @SneakyThrows(UnsupportedEncodingException.class)
  public String utf8ToString(byte[] bytes) {
    return new String(bytes, "UTF-8");
  }
  
  @SneakyThrows
  public void run() {
    throw new Throwable();
  }
}
```
```java
// Vanilla Java

import lombok.Lombok;

public class SneakyThrowsExample implements Runnable {
  public String utf8ToString(byte[] bytes) {
    try {
      return new String(bytes, "UTF-8");
    } catch (UnsupportedEncodingException e) {
      throw Lombok.sneakyThrow(e);
    }
  }
  
  public void run() {
    try {
      throw new Throwable();
    } catch (Throwable t) {
      throw Lombok.sneakyThrow(t);
    }
  }
}
```

### `@Synchronized`

```java
// Lombok

import lombok.Synchronized;

public class SynchronizedExample {
  private final Object readLock = new Object();
  
  @Synchronized
  public static void hello() {
    System.out.println("world");
  }
  
  @Synchronized
  public int answerToLife() {
    return 42;
  }
  
  @Synchronized("readLock")
  public void foo() {
    System.out.println("bar");
  }
}
```
```java
// Vanilla Java

public class SynchronizedExample {
  private static final Object $LOCK = new Object[0];
  private final Object $lock = new Object[0];
  private final Object readLock = new Object();
  
  public static void hello() {
    synchronized($LOCK) {
      System.out.println("world");
    }
  }
  
  public int answerToLife() {
    synchronized($lock) {
      return 42;
    }
  }
  
  public void foo() {
    synchronized(readLock) {
      System.out.println("bar");
    }
  }
}
```

### `@Locked`

```java
// Lombok

import lombok.Locked;

public class LockedExample {
  private int value = 0;
  
  @Locked.Read
  public int getValue() {
    return value;
  }
  
  @Locked.Write
  public void setValue(int newValue) {
    value = newValue;
  }
  
  @Locked("baseLock")
  public void foo() {
    System.out.println("bar");
  }
}
```
```java
// Vanilla Java

public class LockedExample {
  private final ReadWriteLock lock = new ReentrantReadWriteLock();
  private final Lock baseLock = new ReentrantLock();
  private int value = 0;
  
  public int getValue() {
    this.lock.readLock().lock();
    try {
      return value;
    } finally {
      this.lock.readLock().unlock();
    }
  }
  
  public void setValue(int newValue) {
    this.lock.writeLock().lock();
    try {
      value = newValue;
    } finally {
      this.lock.writeLock().unlock();
    }
  }
  
  public void foo() {
    this.baseLock.lock();
    try {
      System.out.println("bar");
    } finally {
      this.baseLock.unlock();
    }
  }
}
```

### `@With`

```java
// Lombok

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.With;

public class WithExample {
  @With(AccessLevel.PROTECTED) @NonNull private final String name;
  @With private final int age;
  
  public WithExample(@NonNull String name, int age) {
    this.name = name;
    this.age = age;
  }
}
```
```java
// Vanilla Java

import lombok.NonNull;

public class WithExample {
  private @NonNull final String name;
  private final int age;

  public WithExample(String name, int age) {
    if (name == null) throw new NullPointerException();
    this.name = name;
    this.age = age;
  }

  protected WithExample withName(@NonNull String name) {
    if (name == null) throw new java.lang.NullPointerException("name");
    return this.name == name ? this : new WithExample(name, age);
  }

  public WithExample withAge(int age) {
    return this.age == age ? this : new WithExample(name, age);
  }
}
```

### `@Getter(lazy=true)`

```java
// Lombok

import lombok.Getter;

public class GetterLazyExample {
  @Getter(lazy=true) private final double[] cached = expensive();
  
  private double[] expensive() {
    double[] result = new double[1000000];
    for (int i = 0; i < result.length; i++) {
      result[i] = Math.asin(i);
    }
    return result;
  }
}
```
```java
// Vanilla Java

public class GetterLazyExample {
  private final java.util.concurrent.AtomicReference<java.lang.Object> cached = new java.util.concurrent.AtomicReference<java.lang.Object>();
  
  public double[] getCached() {
    java.lang.Object value = this.cached.get();
    if (value == null) {
      synchronized(this.cached) {
        value = this.cached.get();
        if (value == null) {
          final double[] actualValue = expensive();
          value = actualValue == null ? this.cached : actualValue;
          this.cached.set(value);
        }
      }
    }
    return (double[])(value == this.cached ? null : value);
  }
  
  private double[] expensive() {
    double[] result = new double[1000000];
    for (int i = 0; i < result.length; i++) {
      result[i] = Math.asin(i);
    }
    return result;
  }
}
```

### `@Log`

```java
// Lombok

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Log
public class LogExample {
  
  public static void main(String... args) {
    log.severe("Something's wrong here");
  }
}

@Slf4j
public class LogExampleOther {
  
  public static void main(String... args) {
    log.error("Something else is wrong here");
  }
}

@CommonsLog(topic="CounterLog")
public class LogExampleCategory {

  public static void main(String... args) {
    log.error("Calling the 'CounterLog' with a message");
  }
}
```
```java
// Vanilla Java

public class LogExample {
  private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger(LogExample.class.getName());
  
  public static void main(String... args) {
    log.severe("Something's wrong here");
  }
}

public class LogExampleOther {
  private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(LogExampleOther.class);
  
  public static void main(String... args) {
    log.error("Something else is wrong here");
  }
}

public class LogExampleCategory {
  private static final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog("CounterLog");

  public static void main(String... args) {
    log.error("Calling the 'CounterLog' with a message");
  }
}
```

### 

```java
// Lombok

```
```java
// Vanilla Java

```

:wq