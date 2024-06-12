package com.app.shop.configuration;

import com.app.shop.entities.Category;
import com.app.shop.model.dto.CategoryDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        modelMapper.addMappings(changeCategoriesMapping);

        return modelMapper;
    }

    transient PropertyMap<Category, CategoryDTO> changeCategoriesMapping = new PropertyMap<>() {
        @Override
        protected void configure() {
            map().setDescription(source.getName());
        }
    };
}
