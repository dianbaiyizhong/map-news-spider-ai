import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.TemplateType;
import org.junit.Test;

public class MysqlCodegen {

    /**
     * 数据源配置
     */


    private static final DataSourceConfig.Builder DATA_SOURCE_CONFIG = new DataSourceConfig
            .Builder("jdbc:mysql://localhost:3306/p7i?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8&useTimezone=true&allowPublicKeyRetrieval=true", "root", "root");

    @Test
    public void generate() {

        String projectPath = System.getProperty("user.dir") + "/" + "/src/main/java";
        FastAutoGenerator.create(DATA_SOURCE_CONFIG)
                .globalConfig(builder -> {
                    builder.author("nntk") // 设置作者
                            .outputDir(projectPath);
                })
                .packageConfig(builder -> {
                    builder.parent("com.nntk.mapnews.mp") // 设置父包名
                            .moduleName("generate")
                            .controller("")
                    ;
                })
                .strategyConfig(builder -> {
                    builder.addInclude("T_USER","t_map_news","t_map_news_source")
                            .mapperBuilder().enableFileOverride()
                            .entityBuilder().enableFileOverride()
                    ;
                }).templateConfig(builder -> {
                    builder.disable(TemplateType.CONTROLLER, TemplateType.SERVICE, TemplateType.SERVICE_IMPL);
                }).execute();
    }
}
