## 心旅
```
习惯于spring框架的我们，看到spring boot还是很亲切的，对于spring boot的自动配置，用了之后确实方便了很多，特别是在开发时，很多默认配置方便我们快速使用，试错，
不需要一大堆繁琐的配置，才能跑起来一个demo，对我来说，确实降低了很多学习成本和试错成本，特别是在做对比抉择的时候，可以快速发现自己真正需要的是哪个，
有时候一个好的开源项目，需要一大堆的配置，才能跑起来一个demo，确实感觉有点不耐烦，不知道大家有没有同感
```
## spring boot 是如何处理自动配置的
### 直观的看
```
spring boot 会扫描META-INF/spring.factories文件，加载key为org.springframework.boot.autoconfigure.EnableAutoConfiguration的配置信息，并进行
bean的配置
```
#### 使用示例
> 配置 spring.factories
```
加入以下信息：
org.springframework.boot.autoconfigure.EnableAutoConfiguration=com.travel.config.ComponentConfiguration
```
> 加上自动配置注解
``` 
@Component
public class PersonComponent {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    public void hello(){
        logger.info("hello world");
    }
}

@Configuration
public class ComponentConfiguration {

    @Bean
    public PersonComponent personComponent(){
        return new PersonComponent();
    }
}


@RestController
/*很关键*/
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.travel.other")
public class App 
{
    public static void main( String[] args ) {
        SpringApplication.run(App.class,args);
    }
}

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK,classes = App.class)
public class AbstractBaseTest {
}

public class AppTest extends AbstractBaseTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired(required = false)
    private PersonComponent personComponent;

    @Test
    public void getConfigObject(){
        logger.info("获取自动配置的对象:{}",personComponent);
    }
}

```
经过上面的简单配置，应用启动就会自动加载ComponentConfiguration配置

### 源码层面
> 经过上面的简单例子，可以感受到spring boot给开发带来的方便，以及可以脑洞大开，迫不及待想利用这个特性做点什么

```
从例子中可以看到注解 EnableAutoConfiguration 起到了关键作用，不加上这个注解自动配置这个特性就会失效，那么这个注解到底做了什么呢！？


@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@AutoConfigurationPackage
@Import({AutoConfigurationImportSelector.class})
public @interface EnableAutoConfiguration {
    String ENABLED_OVERRIDE_PROPERTY = "spring.boot.enableautoconfiguration";

    Class<?>[] exclude() default {};

    String[] excludeName() default {};
}

这个注解上面加上了@Import注解，这个注解的作用跟xml配置文件里面的<import>标签是一样的作用，从源码里面看一下说明

 * Indicates one or more {@link Configuration @Configuration} classes to import.
 *
 * <p>Provides functionality equivalent to the {@code <import/>} element in Spring XML.
 * Allows for importing {@code @Configuration} classes, {@link ImportSelector} and
 * {@link ImportBeanDefinitionRegistrar} implementations, as well as regular component
 * classes (as of 4.2; analogous to {@link AnnotationConfigApplicationContext#register}).
 *
 * <p>{@code @Bean} definitions declared in imported {@code @Configuration} classes should be
 * accessed by using {@link org.springframework.beans.factory.annotation.Autowired @Autowired}
 * injection. Either the bean itself can be autowired, or the configuration class instance
 * declaring the bean can be autowired. The latter approach allows for explicit, IDE-friendly
 * navigation between {@code @Configuration} class methods.
 *
 * <p>May be declared at the class level or as a meta-annotation.
 *
 * <p>If XML or other non-{@code @Configuration} bean definition resources need to be
 * imported, use the {@link ImportResource @ImportResource} annotation instead.

从上面的说明可以知道 这个注解允许 @Configuration类，ImportSelector，ImportBeanDefinitionRegistrar，还有普通的组件都可以使用这个注解导入相关bean配置

这个地方的AutoConfigurationImportSelector主要是为了获取META-INF/spring.factories配置信息,从而把配置的信息注入到spring的上下文中
```