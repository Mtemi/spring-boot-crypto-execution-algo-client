package com.ismail.algo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Generic EnumInteger that will load the field names and their values automatically
 * 
 * @author ismail
 * @since 20221028
 */
public abstract class EnumIntGeneric implements IEnumInteger
{
    private static final HashMap<Class, IntFieldData> sFieldData = new HashMap<>();

    protected IntFieldData mFieldData = null;

    public EnumIntGeneric()
    {
        mFieldData = getFieldData(getClass());
    }

    @Override
    public final String getItemDescription(int pValue)
    {
        String val = mFieldData.mFieldNameByValue.get(pValue);
        if (val == null)
            val = "Unknown-" + pValue;

        return val;
    }

    protected static IntFieldData getFieldData(Class clazz)
    {
        IntFieldData fieldData = sFieldData.get(clazz);

        if (fieldData == null)
        {
            fieldData = new IntFieldData();

            loadStaticFields(clazz, fieldData);

            sFieldData.put(clazz, fieldData);
        }

        return fieldData;
    }

    protected static int[] getValues(Class clazz)
    {
        IntFieldData fieldData = getFieldData(clazz);
        return fieldData.mFieldValues;
    }

    protected static String[] getNames(Class clazz)
    {
        IntFieldData fieldData = getFieldData(clazz);
        return fieldData.mFieldNames;
    }

    private static final void loadStaticFields(Class clazz, IntFieldData fieldData)
    {
        try
        {
            Field[] declaredFields = clazz.getDeclaredFields();

            ArrayList<Field> staticFields = new ArrayList<>();

            ArrayList<Integer> values = new ArrayList<>(20);
            ArrayList<String> names = new ArrayList<>();

            for (Field field : declaredFields)
            {
                if (java.lang.reflect.Modifier.isStatic(field.getModifiers()) == false)
                    continue;

                if ("int".equals(field.getType().getName()) == false)
                    continue;

                if (field.canAccess(null) == false)
                    continue;

                // make sure it is int
                staticFields.add(field);

                // get the value
                String name = field.getName();
                int val = field.getInt(null);

                // check for duplicate values
                if (values.contains(val))
                    throw new IllegalStateException("Duplicate field value: " + val + " in class " + clazz.getName());

                fieldData.mFieldNameByValue.put(val, name);
                fieldData.mFieldValueByName.put(name, val);

                values.add(val);
                names.add(name);
            }

            fieldData.mFieldNames = names.toArray(new String[names.size()]);
            fieldData.mFieldValues = new int[values.size()];
            for (int i = 0; i < values.size(); i++)
                fieldData.mFieldValues[i] = values.get(i);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    protected static class IntFieldData
    {
        public int[] mFieldValues = null;

        public String[] mFieldNames = null;

        public HashMap<Integer, String> mFieldNameByValue = new HashMap<>();

        public HashMap<String, Integer> mFieldValueByName = new HashMap<>();

    }
}
