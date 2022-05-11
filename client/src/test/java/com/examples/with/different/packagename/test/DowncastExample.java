/*
 * Copyright (C) 2010-2018 Gordon Fraser, Andrea Arcuri and EvoSuite
 * contributors
 *
 * Copyright (C) 2021- SmartUt contributors
 *
 * SmartUt is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published
 * by the Free Software Foundation, either version 3.0 of the License, or
 * (at your option) any later version.
 *
 * SmartUt is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with SmartUt. If not, see <http://www.gnu.org/licenses/>.
 */
package com.examples.with.different.packagename.test;

/**
 * Created by gordon on 27/12/2016.
 */
public class DowncastExample {

    public Number getANumber(int x) {
        if(x == 42) {
            return 42;
        } else {
            return 0.0;
        }
    }

    public boolean testMe(Number x) {
        if(x instanceof Double) {
            return true;
        } else {
            return false;
        }
    }

    public boolean testWithInteger(Integer x) {
        if(x.equals(42)) {
            return true;
        } else {
            return false;
        }
    }

    public AbstractSuperclass getAbstractFoo() {
        return new ConcreteSubclass();
    }
}
