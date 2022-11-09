package demo.lombok.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

/**
 Copyright 2015 Mahram Z. Foadi
 <p/>
 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at
 <p/>
 http://www.apache.org/licenses/LICENSE-2.0
 <p/>
 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 /*
 <p/>
 /**

 @author mahram */

@Builder (buildMethodName = "create", builderMethodName = "create")
@Getter
@ToString
@EqualsAndHashCode
public class User {
    @NonNull private final String id;

    @Setter private String name;
    @Setter private String dept;
    @Setter private int    salary;
}
