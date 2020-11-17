package com.tim.tools.starter;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.core.ResolvableType;

import java.lang.annotation.Annotation;
import java.util.Map;

public class FlinkBootContext implements ListableBeanFactory {

    private ApplicationContext context;

    private FlinkBootContext() {
    }

    @Override
    public boolean containsBeanDefinition(String s) {
        return context.containsBeanDefinition(s);
    }

    @Override
    public int getBeanDefinitionCount() {
        return this.context.getBeanDefinitionCount();
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return this.context.getBeanDefinitionNames();
    }

    @Override
    public String[] getBeanNamesForType(ResolvableType resolvableType) {
        return this.context.getBeanNamesForType(resolvableType);
    }

    @Override
    public String[] getBeanNamesForType(ResolvableType resolvableType, boolean b, boolean b1) {
        return this.context.getBeanNamesForType(resolvableType, b, b1);
    }

    @Override
    public String[] getBeanNamesForType(Class<?> aClass) {
        return this.context.getBeanNamesForType(aClass);
    }

    @Override
    public String[] getBeanNamesForType(Class<?> aClass, boolean b, boolean b1) {
        return this.context.getBeanNamesForType(aClass, b, b1);
    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> aClass) throws BeansException {
        return this.context.getBeansOfType(aClass);
    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> aClass, boolean b, boolean b1) throws BeansException {
        return this.context.getBeansOfType(aClass, b, b1);
    }

    @Override
    public String[] getBeanNamesForAnnotation(Class<? extends Annotation> aClass) {
        return this.context.getBeanNamesForAnnotation(aClass);
    }

    @Override
    public Map<String, Object> getBeansWithAnnotation(Class<? extends Annotation> aClass) throws BeansException {
        return this.context.getBeansWithAnnotation(aClass);
    }

    @Override
    public <A extends Annotation> A findAnnotationOnBean(String s, Class<A> aClass) throws NoSuchBeanDefinitionException {
        return this.context.findAnnotationOnBean(s, aClass);
    }

    @Override
    public Object getBean(String s) throws BeansException {
        return this.context.getBean(s);
    }

    @Override
    public <T> T getBean(String s, Class<T> aClass) throws BeansException {
        return this.context.getBean(s, aClass);
    }

    @Override
    public Object getBean(String s, Object... objects) throws BeansException {
        return this.context.getBean(s, objects);
    }

    @Override
    public <T> T getBean(Class<T> aClass) throws BeansException {
        return this.context.getBean(aClass);
    }

    @Override
    public <T> T getBean(Class<T> aClass, Object... objects) throws BeansException {
        return this.context.getBean(aClass, objects);
    }

    @Override
    public <T> ObjectProvider<T> getBeanProvider(Class<T> aClass) {
        return this.context.getBeanProvider(aClass);
    }

    @Override
    public <T> ObjectProvider<T> getBeanProvider(ResolvableType resolvableType) {
        return this.context.getBeanProvider(resolvableType);
    }

    @Override
    public boolean containsBean(String s) {
        return this.context.containsBean(s);
    }

    @Override
    public boolean isSingleton(String s) throws NoSuchBeanDefinitionException {
        return this.context.isSingleton(s);
    }

    @Override
    public boolean isPrototype(String s) throws NoSuchBeanDefinitionException {
        return this.context.isPrototype(s);
    }

    @Override
    public boolean isTypeMatch(String s, ResolvableType resolvableType) throws NoSuchBeanDefinitionException {
        return this.context.isTypeMatch(s, resolvableType);
    }

    @Override
    public boolean isTypeMatch(String s, Class<?> aClass) throws NoSuchBeanDefinitionException {
        return this.context.isTypeMatch(s, aClass);
    }

    @Override
    public Class<?> getType(String s) throws NoSuchBeanDefinitionException {
        return this.context.getType(s);
    }

    @Override
    public Class<?> getType(String s, boolean b) throws NoSuchBeanDefinitionException {
        return this.context.getType(s, b);
    }

    @Override
    public String[] getAliases(String s) {
        return this.context.getAliases(s);
    }

    public static FlinkBootContext getInstance() {
        return Singleton.CONTEXT;
    }

    private static class Singleton {
        private static final FlinkBootContext CONTEXT = new FlinkBootContext();
    }

    public ApplicationContext getContext() {
        return context;
    }

    void setContext(ApplicationContext context) {
        this.context = context;
    }
}
