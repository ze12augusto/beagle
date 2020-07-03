//Replace CucumberishExampleUITests with the name of your swift test target
#import "BeagleDemoUITests-Swift.h"

__attribute__((constructor))

void CucumberishInit()
{
    [CucumberishInitializer CucumberishSwiftInit];
}
