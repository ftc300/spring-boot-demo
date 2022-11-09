package demo.lombok.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
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
// TODO: try enabling this line. What does it break?
//@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
@Getter
public class TrackedShape
  extends Shape {

    // required, because not null
    @NonNull private final String id;

    // required, because final
    final private long timestamp;

    // not required
    @Setter private String localReference;

    // not required
    @Setter private boolean lost;
}
